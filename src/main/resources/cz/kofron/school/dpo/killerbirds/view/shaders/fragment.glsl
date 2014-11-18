varying vec2 var_texCoord;
uniform sampler2D tex;

void main()
{
    gl_FragColor = texture2D(tex, var_texCoord);
}
