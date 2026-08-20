package tris;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class bootloader extends Activity {
    static { System.loadLibrary("tris"); }

    private native void nativeInit(Object surface);
    private native void nativeFrame(float dt);

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        SurfaceView sv = new SurfaceView(this);
        setContentView(sv);

        sv.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                nativeInit(holder.getSurface());
            }

            @Override public void surfaceChanged(SurfaceHolder h, int f, int w, int h2) {}
            @Override public void surfaceDestroyed(SurfaceHolder h) {}
        });

        new Thread(() -> {
            long last = System.nanoTime();
            while (true) {
                long now = System.nanoTime();
                float dt = (now - last) / 1e9f;
                last = now;

                nativeFrame(dt);

                try { Thread.sleep(16); } catch (Exception e) {}
            }
        }).start();
    }
}
