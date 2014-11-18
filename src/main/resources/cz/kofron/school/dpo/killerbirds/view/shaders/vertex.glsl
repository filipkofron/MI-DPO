//the position of the vertex as specified by our renderer
attribute vec3 in_vertex;
attribute vec2 in_texCoord;

uniform vec2 uni_offset;

varying vec2 var_texCoord;

void main()
{
    vec3 vertex = vec3(in_vertex.xy + uni_offset, in_vertex.z);
    gl_Position = vec4(vertex, 1.0);
    var_texCoord = in_texCoord;
}
