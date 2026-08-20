#version 450
layout(location = 0) in vec2 pos; void main() { gl_Position = 
    vec4(pos, 0.0, 1.0);
}
EOF cat > TRIS/shaders/tris.frag <<EOF
#version 450
layout(location = 0) out vec4 outColor; void main() { outColor = 
    vec4(1.0, 1.0, 1.0, 1.0);
}
