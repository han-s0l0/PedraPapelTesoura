//Hanna Dias, F3467A0, SI4P68

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PPT {
	private static int contUser = 0;
    private static int contCPU = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pedra, Papel ou Tesoura");
        JPanel panel = new JPanel();

        String options[] = {"Pedra", "Papel", "Tesoura"};

        JLabel titulo = new JLabel("Pedra, Papel ou Tesoura");
        JLabel jogador = new JLabel("Usuário: ");
        JLabel cpu = new JLabel("CPU: ");
        JLabel pointPlayer = new JLabel();
        JLabel pointCPU = new JLabel();
        JComboBox<String> escolha = new JComboBox<>(options);
        JButton jogarButton = new JButton("JOGAR");
        JLabel label = new JLabel("Escolha:");

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        jogarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int escolhaIndex = escolha.getSelectedIndex();

                String[] choices = {"Pedra", "Papel", "Tesoura"};
                int computerChoiceIndex = generateRandomIndex(choices.length);
                String computerChoice = choices[computerChoiceIndex];
                
                if (escolhaIndex == computerChoiceIndex){
                    JOptionPane.showMessageDialog(null, "O computador escolheu:  " + computerChoice + "\n Empatou!!");
                  }
                else if (escolhaIndex == 0 && computerChoiceIndex == 1) {
                	JOptionPane.showMessageDialog(null, "O computador escolheu:  " + computerChoice + "\n Você perdeu :(");
                	contCPU += 1;
                    pointCPU.setText(String.valueOf(contCPU));
                }
                else if (escolhaIndex == 0 && computerChoiceIndex == 2) {
                	JOptionPane.showMessageDialog(null, "O computador escolheu:  " + computerChoice + "\n Você ganhou :)");
                	contUser += 1;
                    pointPlayer.setText(String.valueOf(contUser));
                }
                else if (escolhaIndex == 1 && computerChoiceIndex == 0) {
                	JOptionPane.showMessageDialog(null, "O computador escolheu:  " + computerChoice + "\n Você ganhou :)");
                	contUser += 1;
                    pointPlayer.setText(String.valueOf(contUser));
                }
                else if (escolhaIndex == 1 && computerChoiceIndex == 2) {
                	JOptionPane.showMessageDialog(null, "O computador escolheu:  " + computerChoice + "\n Você perdeu :(");
                	contCPU += 1;
                    pointCPU.setText(String.valueOf(contCPU));
                }
                else if (escolhaIndex == 2 && computerChoiceIndex == 0) {
                	JOptionPane.showMessageDialog(null, "O computador escolheu:  " + computerChoice + "\n Você perdeu :(");
                	contCPU += 1;
                    pointCPU.setText(String.valueOf(contCPU));
                }
                else if (escolhaIndex == 2 && computerChoiceIndex == 1) {
                	JOptionPane.showMessageDialog(null, "O computador escolheu:  " + computerChoice + "\n Você ganhou :)");
                	contUser += 1;
                    pointPlayer.setText(String.valueOf(contUser));
                }     
            }
        });
        
        titulo.setFont(new Font("Arial", 1, 30));

        panel.setLayout(null);
        titulo.setBounds(210, 20, 600, 50);
        jogador.setBounds(250, 100, 100, 30);
        cpu.setBounds(460, 100, 100, 30);
        pointPlayer.setBounds(320, 100, 20, 30);
        pointCPU.setBounds(510, 100, 20, 30);
        label.setBounds(300, 170, 100, 30);
        escolha.setBounds(360, 170, 100, 30);
        jogarButton.setBounds(260, 250, 250, 70);

        panel.add(titulo);
        panel.add(jogador);
        panel.add(pointPlayer);
        panel.add(cpu);
        panel.add(pointCPU);
        panel.add(label);
        panel.add(escolha);
        panel.add(jogarButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static int generateRandomIndex(int maxIndex) {
        Random random = new Random();
        return random.nextInt(maxIndex);
    }
}
