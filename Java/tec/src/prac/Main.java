package prac;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ball basketBall = new Ball(25,"Orange");
		Ball soccerBall = new Ball(20,"White");
		Ball footBall = new Ball(23, "Brown");
		
		basketBall.bounce();
		soccerBall.bounce();
		footBall.bounce();
		soccerBall.deflate();
		footBall.deflate();
		basketBall.bounce();
		soccerBall.bounce();
		footBall.bounce();
		footBall.inflate();
		basketBall.bounce();
		soccerBall.bounce();
		footBall.bounce();
		soccerBall.changeColor("Pink");
		basketBall.changeColor("Blue");
		basketBall.bounce();
		soccerBall.bounce();
		footBall.bounce();
		
	}

}
