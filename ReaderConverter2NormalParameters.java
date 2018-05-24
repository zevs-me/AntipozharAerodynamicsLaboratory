package zevs;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ReaderConverter2NormalParameters extends JFrame{
JButton b1,b2;
JLabel l1,l2,l3,l4,l5;
JTextField t1Speed, t2Square, t3Temperature, t4Pressure;
EHandler handler = new EHandler();
double speed=0,square=0,temperature=0,temperatureKelvin=0, pressure=0,volume=0, normalVolume=0;
double normalTemperature = 273.15;
double normalPressure = 101.3;
String result;

	public ReaderConverter2NormalParameters(String s) {
		super(s);
		setLayout(new FlowLayout());		
		b1=new JButton ("Calculate");
		b2=new JButton("Clear");
		l1=new JLabel("Введите среднюю скорость движения воздуха");
		l2=new JLabel("Введите площадь мерного сечения");
		l3 = new JLabel("Введите температуру");
		l4=new JLabel("Введите атмосферное давление");
		l5 = new JLabel("");
		t1Speed = new JTextField(10);
		t2Square = new JTextField(10);
		t3Temperature = new JTextField(10);
		t4Pressure = new JTextField(10);
		add(t1Speed); add(l1);
		add(t2Square); add(l2);
		add(t3Temperature); add(l3);
		add(t4Pressure); add(l4);
		add(l5);
		add(b1);
		add(b2);
		b1.addActionListener(handler);
		b2.addActionListener(handler);
	}
public class EHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			if (e.getSource()==b1) {
				pressure = Double.parseDouble(t4Pressure.getText());
				speed=Double.parseDouble(t1Speed.getText());
				square=Double.parseDouble(t2Square.getText());
				temperature = Double.parseDouble(t3Temperature.getText());
				temperatureKelvin = temperature+273.15;
				volume=speed*square*3600;
			normalVolume = pressure*volume*normalTemperature/temperatureKelvin/normalPressure;
			result = Double.toString(normalVolume);
			l5.setText("Объемный расход при нормальных условиях = "+result+" м3");
			}
			if (e.getSource()==b2) {
				l5.setText("");
				pressure=0;
				volume=0;
				temperature=0;
				t1Speed.setText(null);
				t2Square.setText(null);
				t3Temperature.setText(null);
				t4Pressure.setText(null);
				
				
				
			}
			
			
		}catch(Exception exception) {
			JOptionPane.showMessageDialog(null, "Введите корректные данные !");
		}
			
		}
	}
	
}
