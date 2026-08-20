package tris;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class bootloader extends Activity {
    static { System.loadLibrary("tris"); }

    private native void nativeInit(Object surface);
    private native void nativeFrame(float dt);

    private SurfaceView surfaceView;
    private Thread renderThread;
    private volatile boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        surfaceView = new SurfaceView(this);
        setContentView(surfaceView);

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                nativeInit(holder.getSurface());
                startRenderLoop();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                // Nessuna azione richiesta qui.
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                stopRenderLoop();
            }
        });
    }

    private void startRenderLoop() {
        if (renderThread != null && renderThread.isAlive()) {
            return;
        }

        running = true;
        renderThread = new Thread(() -> {
            long last = System.nanoTime();
            while (running) {
                long now = System.nanoTime();
                float dt = (now - last) / 1e9f;
                last = now;

                nativeFrame(dt);

                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }, "tris-render-thread");

        renderThread.start();
    }

    private void stopRenderLoop() {
        running = false;
        if (renderThread != null) {
            renderThread.interrupt();
            renderThread = null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopRenderLoop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (surfaceView != null && surfaceView.getHolder().getSurface() != null) {
            startRenderLoop();
        }
    }

    @Override
    protected void onDestroy() {
        stopRenderLoop();
        super.onDestroy();
    }
}
