package zevs;
import javax.swing.JFrame;
public class Converter2NormalParameters {
public static void main (String args[]) {
	ReaderConverter2NormalParameters reader = new ReaderConverter2NormalParameters("Antipozhar aerodynamics laboratory");
	reader.setVisible(true);
	reader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	reader.setSize(750,200);
	reader.setResizable(false);
	reader.setLocationRelativeTo(null);
}
}
