"use strict";

var Sphere = function() {
    var canvas;
    var gl;

    var numTimesToSubdivide = 3;

    var index = 0;

    var positionsArray = [];

    var lightAmbient = vec4(0.2, 0.2, 0.2, 1.0);
    var lightDiffuse = vec4(1.0, 1.0, 2471.0, 1.0);
    var lightSpecular = vec4(1.0, 1.0, 1.0, 1.0);

    var lightPosition = vec4(-1.0, -1.0, 2.0, .5);

    var materialAmbient = vec4(1.0, 0.0, 1.0, 1.0);
    var materialDiffuse = vec4(1.0, 0.8, 0.0, 1.0);
    var materialSpecular = vec4(1.0, 0.8, 0.0, 1.0);

    var materialShininess = 100.0;

    var ambientColor, diffuseColor, specularColor;


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

    var modelViewMatrix, projectionMatrix;
    var modelViewMatrixLoc, projectionMatrixLoc;
    var eye;
    const at = vec3(0.0, 0.0, 0.0);
    const up = vec3(0.0, 1.0, 0.0);

    function triangle(a, b, c) {
        positionsArray.push(a);
        positionsArray.push(b);
        positionsArray.push(c);
        index += 3;
    }


    function divideTriangle(a, b, c, count) {
        if (count > 0) {

            var ab = normalize(mix( a, b, 0.5), true);
            var ac = normalize(mix( a, c, 0.5), true);
            var bc = normalize(mix( b, c, 0.5), true);


            divideTriangle(a, ab, ac, count - 1);
            divideTriangle(ab, b, bc, count - 1);
            divideTriangle(bc, c, ac, count - 1);
            divideTriangle(ab, bc, ac, count - 1);
        }
        else {
            triangle(a, b, c);
        }
    }

    function tetrahedron(a, b, c, d, n) {
        divideTriangle(a, b, c, n);
        divideTriangle(d, c, b, n);
        divideTriangle(a, d, b, n);
        divideTriangle(a, c, d, n);
    }

    window.onload = function init() {
        canvas = document.getElementById("gl-canvas");

        gl = canvas.getContext('webgl2');
        if (!gl) alert("WebGL 2.0 isn't available");


        gl.viewport(0, 0, canvas.width, canvas.height);
        gl.clearColor(.9, 1.0, 1.0, 1.0);
        gl.enable(gl.DEPTH_TEST);

        var program = initShaders(gl, "vertex-shader", "fragment-shader");
        gl.useProgram(program);

        



        var va = vec4(0.0, 0.0, -1.0, 1);
        var vb = vec4(0.0, 0.942809, 0.333333, 1);
        var vc = vec4(-0.816497, -0.471405, 0.333333, 1);
        var vd = vec4(0.816497, -0.471405, 0.333333, 1);

        var ambientProduct = mult(lightAmbient, materialAmbient);
        var diffuseProduct = mult(lightDiffuse, materialDiffuse);
        var specularProduct = mult(lightSpecular, materialSpecular);

        tetrahedron(va, vb, vc, vd, numTimesToSubdivide);

        var vBuffer = gl.createBuffer();
        gl.bindBuffer( gl.ARRAY_BUFFER, vBuffer);
        gl.bufferData( gl.ARRAY_BUFFER, flatten(positionsArray), gl.STATIC_DRAW);

        var positionLoc = gl.getAttribLocation( program, "aPosition");
        gl.vertexAttribPointer( positionLoc, 4, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(positionLoc);

        modelViewMatrixLoc = gl.getUniformLocation(program, "uModelViewMatrix");
        projectionMatrixLoc = gl.getUniformLocation(program, "uProjectionMatrix");

        document.getElementById("Button0").onclick = function(){theta += dr;};
        document.getElementById("Button1").onclick = function(){theta -= dr;};
        document.getElementById("Button2").onclick = function(){phi += dr;};
        document.getElementById("Button3").onclick = function(){phi -= dr;};

        document.getElementById("Button4").onclick = function(){
            numTimesToSubdivide++;
            index = 0;
            positionsArray = [];
            init();
        };
        document.getElementById("Button5").onclick = function(){
            if(numTimesToSubdivide) numTimesToSubdivide--;
            index = 0;
            positionsArray = [];
            init();
        };

        document.getElementById("Button6").onclick = function(){
            lightPosition = vec4(-1.0, -1.0, 3.0, .5);
            index = 0;
            positionsArray = [];
            init();
        };

        document.getElementById("Button7").onclick = function(){
            lightPosition = vec4(1.0, -1.0, 3.0, .5);
            index = 0;
            positionsArray = [];
            init();
        };

        document.getElementById("Button8").onclick = function(){
            lightPosition = vec4(-1.0, 1.0, 3.0, .5);
            index = 0;
            positionsArray = [];
            init();
        };

        document.getElementById("Button9").onclick = function(){
            lightPosition = vec4(1.0, 1.0, 3.0, .5);
            index = 0;
            positionsArray = [];
            init();
        };

        document.getElementById("Button10").onclick = function(){
            materialShininess += 20;
            index = 0;
            positionsArray = [];
            init();
        };
        document.getElementById("Button11").onclick = function(){
            if (materialShininess) materialShininess -= 20;
            index = 0;
            positionsArray = [];
            init();
        };

        gl.uniform4fv( gl.getUniformLocation(program,
            "uAmbientProduct"), ambientProduct );
         gl.uniform4fv( gl.getUniformLocation(program,
            "uDiffuseProduct"), diffuseProduct );
         gl.uniform4fv( gl.getUniformLocation(program,
            "uSpecularProduct"), specularProduct );
         gl.uniform4fv( gl.getUniformLocation(program,
            "uLightPosition"), lightPosition );
         gl.uniform1f( gl.getUniformLocation(program,
            "uShininess"),materialShininess );


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


        for( var i=0; i<index; i+=3)
        gl.drawArrays(gl.TRIANGLES, i, 3);

        requestAnimationFrame(render);


    }

}
Sphere();