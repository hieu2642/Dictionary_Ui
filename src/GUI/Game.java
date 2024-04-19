package GUI;

import Dictionary.DictionaryManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JDialog implements ActionListener {
    JDialog addWindow = new JDialog();
    JTextArea answer = new JTextArea();
    JTextArea question = new JTextArea();
    JTextArea explain = new JTextArea();
    JButton checkButton = new JButton("Check");
    JButton nextButton = new JButton("Start");
    JLabel answerLabel = new JLabel("Your answer");
    JLabel questionLabel = new JLabel("Word Meaning");
    JFrame dialogFrame = new JFrame();
    JScrollPane scrollQuestion = new JScrollPane(question, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//    JScrollPane scrollExplain = new JScrollPane(explain, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    public Game(String option) {
        checkButton.setBounds(630, 515, 200, 55);
        checkButton.setBorderPainted(true);
        checkButton.addActionListener(this);

        nextButton.setBounds(180,515,200,55);
        nextButton.setBorderPainted(true);
        nextButton.addActionListener(this);

        questionLabel.setFont(new Font("Times New Roman", Font.ITALIC,20));
        questionLabel.setBounds(15,10,300,30);

        question.setBounds(15, 42, 530,200);
        question.setFont(new Font("Times New Roman", Font.ITALIC,20));
        question.setWrapStyleWord(true);
        question.setLineWrap(true);

        answerLabel.setFont(new Font("Times New Roman", Font.ITALIC,20));
        answerLabel.setBounds(15,248,300,30);

        answer.setBounds(15, 285, 530,200); //130
        answer.setFont(new Font("Times New Roman", Font.BOLD,20));

        explain.setBounds(560, 42, 325,443);
        explain.setFont(new Font("Times New Roman", Font.BOLD,20));
        explain.setWrapStyleWord(true);
        explain.setLineWrap(true);

        scrollQuestion.setBounds(15, 42, 530,200);
        scrollQuestion.setOpaque(false);
        scrollQuestion.setBackground(Color.white);
        scrollQuestion.setBorder(BorderFactory.createEmptyBorder());

        //addWindow.add(dialogFrame);
        addWindow.add(checkButton);
        addWindow.add(nextButton);
        addWindow.add(question);
        addWindow.add(answer);
        addWindow.add(explain);
        addWindow.add(questionLabel);
        addWindow.add(answerLabel);
        addWindow.add(scrollQuestion);
        addWindow.setLayout(null);
        addWindow.setSize(900,645);
        addWindow.setVisible(true);

        if (option.equals("game")) {
            addWindow.setTitle("Game");
//            this.createQuestion();
            checkButton.addActionListener(this.checkButtonListener);
            nextButton.addActionListener(this.nextButtonListener);
        }
    }


    private String checkAnswer;
    private String explainData;

    private void createQuestion() {
        explain.setText(null);
        FindWord_fromDB finder = new FindWord_fromDB();
        String[] wordInfo = finder.getRandomWordInfo();
        finder.closeConnection();

        String a = wordInfo[2];
        question.setText(a);

        checkAnswer = wordInfo[0];
        explainData = wordInfo[0] + "\n" + wordInfo[1];
    }

    ActionListener checkButtonListener = game -> {
        if(!checkAnswer.equals(answer.getText())) {
            explain.setText("false\n\n\n\n\n\n\n" + explainData);
        } else {
            explain.setText("true\n\n\n\n\n\n\n" + explainData);
        }
    };

    ActionListener nextButtonListener = game -> {
        nextButton.setText("Next");
        this.createQuestion();
    };

    public void actionPerformed(ActionEvent e) {
    }
}
