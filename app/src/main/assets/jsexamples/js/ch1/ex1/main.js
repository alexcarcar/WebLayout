$(document).ready(function() {
	'use strict';
	console.log('main.js loaded');

	paper.install(window);
	paper.setup(document.getElementById('mainCanvas'));

	var c = Shape.Circle(100, 100, 50);
	c.fillColor = 'pink';

	var c = Shape.Circle(300, 100, 50);
	c.fillColor = 'gold';

	var c = Shape.Circle(100, 300, 50);
	c.fillColor = 'black';

	var c = Shape.Circle(300, 300, 50);
	c.fillColor = 'brown';

	var c = Shape.Circle(300, 200, 50);
	c.fillColor = 'orange';

	var c = Shape.Circle(200, 200, 50);
	c.fillColor = 'purple';

	var c = Shape.Circle(200, 100, 50);
	c.fillColor = 'red';

	var c = Shape.Circle(200, 300, 50);
	c.fillColor = 'blue';

	var c = Shape.Circle(100, 200, 50);
	c.fillColor = 'yellow';

	paper.view.draw();
});