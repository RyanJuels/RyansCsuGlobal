"use strict";

var wireSphere = function() {
    var canvas;
    var gl;

    var positions = []

    var near = -10;
    var far = 10;
    var radius = 6.0;
    var theta = 0.0;
    var phi = 0.0;
    var dr = 5.0 * Math.PI/180.0;

    var left = -2.0;
    var right = 2.0;
    var top = 2.0;
    var bottom = -2.0;

    var boxVertices = 
        [
            //Top
            -1, 1, -1,   .5, .5, .5,
            -1, 1, 1,    .5, .5, .5,
            1, 1, 1,     .5, .5, .5,
            1, 1, -1,    .5, .5, .5,

            //Left
            -1, 1, 1,    .75, .25, .5,
            -1, -1, 1,   .75, .25, .5,
            -1, -1, -1,  .75, .25, .5,
            -1, 1, -1,   .75, .25, .5,

            //Right
            1, 1, 1,    0, 0, 1,
            1, -1, 1,   0, 0, 1,
            1, -1, -1,  0, 0, 1,
            1, 1, -1,   0, 0, 1,

            //Front
            1, 1, 1,    1, 0, .15,
            1, -1, 1,    1, 0, .15,
            -1, -1, 1,    1, 0, .15,
            -1, 1, 1,    1, 0, .15,

            //Back
            1, 1, -1,    0, 1, .15,
            1, -1, -1,    0, 1, .15,
            -1, -1, -1,    0, 1, .15,
            -1, 1, -1,    0, 1, .15,

            //Bottom
            -1, -1, -1,   0, 0, 0,
            -1, -1, 1,    0, 0, 0,
            1, -1, 1,     0, 0, 0,
            1, -1, -1,    0, 0, 0,
        ];

        var boxIndices =
        [
            // Top
            0, 1, 2,
            0, 2, 3,

            // Left
            5, 4, 6,
            6, 4, 7,

            // Right
            8, 9, 10,
            8, 10, 11,

            // Front
            13, 12, 14,
            15, 14, 12,

            // Back
            16, 17, 18,
            16, 18, 19,

            // Bottom
            21, 20, 22,
            22, 20, 23
        ];

    var modelViewMatrix, projectionMatrix;
    var modelViewMatrixLoc, projectionMatrixLoc;
    var eye;
    const at = vec3(0.0, 0.0, 0.0);
    const up = vec3(0.0, 1.0, 0.0);

    function initShaders(gl, vertexShaderId, fragmentShaderId)
    {
        var vertShdr;
        var fragShdr;

        var vertElem = document.getElementById( vertexShaderId );
        if ( !vertElem ) {
            alert( "Unable to load vertex shader " + vertexShaderId );
            return -1;
        }
        else {
            vertShdr = gl.createShader( gl.VERTEX_SHADER );
            gl.shaderSource( vertShdr, vertElem.textContent.replace(/^\s+|\s+$/g, '' ));
            gl.compileShader( vertShdr );
            if ( !gl.getShaderParameter(vertShdr, gl.COMPILE_STATUS) ) {
                var msg = "Vertex shader failed to compile.  The error log is:"
                + "<pre>" + gl.getShaderInfoLog( vertShdr ) + "</pre>";
                alert( msg );
                return -1;
            }
        }

        var fragElem = document.getElementById( fragmentShaderId );
        if ( !fragElem ) {
            alert( "Unable to load vertex shader " + fragmentShaderId );
            return -1;
        }
        else {
            fragShdr = gl.createShader( gl.FRAGMENT_SHADER );
            gl.shaderSource( fragShdr, fragElem.textContent.replace(/^\s+|\s+$/g, '' ) );
            gl.compileShader( fragShdr );
            if ( !gl.getShaderParameter(fragShdr, gl.COMPILE_STATUS) ) {
                var msg = "Fragment shader failed to compile.  The error log is:"
                + "<pre>" + gl.getShaderInfoLog( fragShdr ) + "</pre>";
                alert( msg );
                return -1;
            }
        }

        var program = gl.createProgram();
        gl.attachShader( program, vertShdr );
        gl.attachShader( program, fragShdr );
        gl.linkProgram( program );

        if ( !gl.getProgramParameter(program, gl.LINK_STATUS) ) {
            var msg = "Shader program failed to link.  The error log is:"
                + "<pre>" + gl.getProgramInfoLog( program ) + "</pre>";
            alert( msg );
            return -1;
        }

        return program;
    }


    window.onload = function init() {
        console.log("This is working");
        canvas = document.getElementById("gl-canvas");

        gl = canvas.getContext('webgl2');
        if (!gl) alert("WebGL 2.0 isn't available");

        gl.viewport(0, 0, canvas.width, canvas.height);
        gl.clearColor(.75, .75, 1.0, 1.0);

        var program = initShaders(gl, "vertex-shader", "fragment-shader");
        gl.useProgram(program);

        gl.enable(gl.DEPTH_TEST);

        var boxVertexBufferObject = gl.createBuffer();
        gl.bindBuffer(gl.ARRAY_BUFFER, boxVertexBufferObject);
        gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(boxVertices), gl.STATIC_DRAW);

        var boxIndexBufferObject = gl.createBuffer();
        gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, boxIndexBufferObject);
        gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, new Uint16Array(boxIndices), gl.STATIC_DRAW);

        var positionAttribLocation = gl.getAttribLocation(program, 'aPosition');
        var colorAttribLocation = gl.getAttribLocation(program, 'aColor');
        gl.vertexAttribPointer(
            positionAttribLocation,
            3,
            gl.FLOAT,
            gl.FALSE,
            6 * Float32Array.BYTES_PER_ELEMENT,
            0
        );
        gl.vertexAttribPointer(
            colorAttribLocation,
            3,
            gl.FLOAT,
            gl.FALSE,
            6 * Float32Array.BYTES_PER_ELEMENT,
            3 * Float32Array.BYTES_PER_ELEMENT
        );

        gl.enableVertexAttribArray(positionAttribLocation);
	    gl.enableVertexAttribArray(colorAttribLocation);



        var positionLoc = gl.getAttribLocation( program, "aPosition");
        gl.vertexAttribPointer( positionLoc, 4, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(positionLoc);

        modelViewMatrixLoc = gl.getUniformLocation(program, "uModelViewMatrix");
        projectionMatrixLoc = gl.getUniformLocation(program, "uProjectionMatrix");

        document.getElementById("Button0").onclick = function(){theta += dr;};
        document.getElementById("Button1").onclick = function(){theta -= dr;};
        document.getElementById("Button2").onclick = function(){phi += dr;};
        document.getElementById("Button3").onclick = function(){phi -= dr;};
        document.getElementById("depthSlider").onchange = function() {
            far = event.target.value/2;
            near = -event.target.value/2;
        };

        render();
    }

    function render() {

        gl.clear( gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

        eye = vec3(radius*Math.sin(theta)*Math.cos(phi),
            radius*Math.sin(theta)*Math.sin(phi), radius*Math.cos(theta));

        modelViewMatrix = lookAt(eye, at , up);
        projectionMatrix = ortho(left, right, bottom, top, near, far);

        gl.uniformMatrix4fv(modelViewMatrixLoc, false, flatten(modelViewMatrix));
        gl.uniformMatrix4fv(projectionMatrixLoc, false, flatten(projectionMatrix));



        gl.drawElements(gl.TRIANGLES, boxIndices.length, gl.UNSIGNED_SHORT, 0);

        requestAnimationFrame(render);
    }

}
wireSphere();