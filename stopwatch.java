import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{

    JFrame frame = new JFrame();
    JButton start = new JButton("Start");
    JButton reset = new JButton("Reset");
    JLabel time = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;

    //time formats
    String seconds_string = String.format("%02d",seconds);
    String minutes_string = String.format("%02d",minutes);
    String hours_string = String.format("%02d",hours);

    //Timer
    Timer timer = new Timer(1000,new ActionListener(){

        public void actionPerformed(ActionEvent e){

            elapsedTime+=1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000)%60;
            seconds = (elapsedTime/1000)%60;
            String seconds_string = String.format("%02d",seconds);
            String minutes_string = String.format("%02d",minutes);
            String hours_string = String.format("%02d",hours);
            time.setText(hours_string+":"+minutes_string+":"+seconds_string);

        }
    });

    Stopwatch(){

        //label
        time.setText(hours_string+":"+minutes_string+":"+seconds_string);
        time.setBounds(100,100,200,100);
        time.setFont(new Font("Verdana", Font.PLAIN,35));
        time.setBorder(BorderFactory.createBevelBorder(1));
        time.setOpaque(true);
        time.setHorizontalAlignment(JTextField.CENTER);

        //Buttons
        start.setBounds(80,200,100,50);
        start.setFont(new Font("Arial",Font.PLAIN,20));
        start.addActionListener(this);

        reset.setBounds(200,200,100,50);
        reset.setFont(new Font("Arial",Font.PLAIN,20));
        reset.addActionListener(this);

        frame.add(time);
        frame.add(start);
        frame.add(reset);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e){

        if (e.getSource() == start){
            if(started==false){
                started=true;
                start.setText("Stop");
                start();
            }
            else{
                started = false;
                start.setText("Start");
                stop();
            }
        }

        if(e.getSource()==reset){
            started = false;
            start.setText("Start");
            reset();
        }

    }

    void start(){
        timer.start();

    }

    void stop(){
        timer.stop();

    }

    void reset(){
        timer.stop();
        elapsedTime=0;
        hours=0;
        minutes=0;
        seconds=0;
        String seconds_string = String.format("%02d",seconds);
        String minutes_string = String.format("%02d",minutes);
        String hours_string = String.format("%02d",hours);
        time.setText(hours_string+":"+minutes_string+":"+seconds_string);


    }
}
