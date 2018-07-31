import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Vue extends JFrame {
    private Model model;
    private JButton [][] listeButton;
    private JPanel plateau;
    private Dimension dimension = new Dimension(90,90);

    private Icon reineNoir;
    private Icon roiNoir;
    private Icon tourNoir;

    private URL urlRoiNoir = getClass().getResource("images/roiNoir.png");
    private URL urlReineNoir = getClass().getResource("images/reineNoir.png");
    private URL urlTourNoir = getClass().getResource("images/TourNoir.png");

    public Vue(Model m){
        this.model = m;
        initAttribut();
        plateau();
        setTitle("Echecs");
        setSize(800, 800);
        actualiser();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void initAttribut(){
        listeButton = new JButton[8][8];
        plateau = new JPanel();
        plateau.setLayout(new GridLayout(8,8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                listeButton[i][j] = new JButton();
                listeButton[i][j].setPreferredSize(dimension);
                plateau.add(listeButton[i][j]);
                listeButton[i][j].setActionCommand(""+i+j);
            }

        }
        reineNoir = new ImageIcon(urlReineNoir);
        roiNoir = new ImageIcon(urlRoiNoir);
        tourNoir = new ImageIcon(urlTourNoir);
    }

    public void plateau() {
        JPanel board = new JPanel();
        board.add(plateau);
        setContentPane(board);
    }

    public void actualiser() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i%2 > 0) {
                    if (j % 2 > 0) {
                        listeButton[i][j].setBackground(Color.GRAY);
                    } else {
                        listeButton[i][j].setBackground(Color.WHITE);
                    }
                }else {
                    if (j%2 > 0) {
                        listeButton[i][j].setBackground(Color.WHITE);
                    }else{
                        listeButton[i][j].setBackground(Color.GRAY);
                    }
                }
            }
        }
        listeButton[0][3].setIcon(roiNoir);
        listeButton[0][4].setIcon(reineNoir);
        listeButton[0][0].setIcon(tourNoir);
        listeButton[0][7].setIcon(tourNoir);
    }

}
