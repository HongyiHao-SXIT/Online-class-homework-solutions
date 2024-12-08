import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PsychologicalTestGUI {

    private JFrame frame;
    private ButtonGroup group1, group2, group3, group4, group5;
    private JButton submitButton;
    private JTextArea resultArea;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PsychologicalTestGUI().createAndShowGUI());
    }

    public void createAndShowGUI() {
        frame = new JFrame("心理测试");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        // 问题1
        panel.add(new JLabel("1. 你是否经常感到焦虑？"));
        group1 = new ButtonGroup();
        panel.add(createRadioButtonPanel(group1, "a. 经常", "b. 偶尔", "c. 从不"));

        // 问题2
        panel.add(new JLabel("2. 你如何看待自己的人际关系？"));
        group2 = new ButtonGroup();
        panel.add(createRadioButtonPanel(group2, "a. 很好，我有很多朋友", "b. 一般，朋友不多但足够", "c. 很差，我没有什么朋友"));

        // 问题3
        panel.add(new JLabel("3. 你在压力下工作时的表现如何？"));
        group3 = new ButtonGroup();
        panel.add(createRadioButtonPanel(group3, "a. 非常好，能高效完成任务", "b. 一般，有时能应对，有时感到压力", "c. 很差，容易崩溃"));

        // 问题4
        panel.add(new JLabel("4. 你会经常自我批评吗？"));
        group4 = new ButtonGroup();
        panel.add(createRadioButtonPanel(group4, "a. 经常", "b. 偶尔", "c. 从不"));

        // 问题5
        panel.add(new JLabel("5. 你对未来感到乐观吗？"));
        group5 = new ButtonGroup();
        panel.add(createRadioButtonPanel(group5, "a. 非常乐观", "b. 有时乐观，有时悲观", "c. 不太乐观"));

        // 结果显示区域
        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        frame.add(resultScrollPane, BorderLayout.SOUTH);

        // 提交按钮
        submitButton = new JButton("提交");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int score = 0;
                score += getScore(group1);
                score += getScore(group2);
                score += getScore(group3);
                score += getScore(group4);
                score += getScore(group5);
                showResult(score);
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(submitButton, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    private JPanel createRadioButtonPanel(ButtonGroup group, String... options) {
        JPanel panel = new JPanel();
        for (String option : options) {
            JRadioButton radioButton = new JRadioButton(option);
            group.add(radioButton);
            panel.add(radioButton);
        }
        return panel;
    }

    private int getScore(ButtonGroup group) {
        int score = 0;
        for (AbstractButton button : group.getElements()) {
            if (button.isSelected()) {
                switch (button.getText().charAt(0)) {
                    case 'a': score = 3; break;
                    case 'b': score = 2; break;
                    case 'c': score = 1; break;
                }
            }
        }
        return score;
    }

    private void showResult(int score) {
        String result = "";
        if (score <= 5) {
            result = "你目前心理状态良好，情绪稳定，能够较好地应对生活中的压力和挑战。";
        } else if (score <= 10) {
            result = "你有一定的压力和焦虑感，建议关注自身情绪，适时释放压力。";
        } else {
            result = "你可能正经历较大的心理压力，建议尽快寻求专业帮助，处理心理问题。";
        }
        resultArea.setText(result);
    }
}
