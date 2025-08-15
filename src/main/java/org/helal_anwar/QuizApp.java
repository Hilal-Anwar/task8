package org.helal_anwar;

import java.util.*;

public class QuizApp {
    static final String[] PRIZES = {
            "₹1,000", "₹2,000", "₹3,000", "₹5,000", "₹10,000",
            "₹20,000", "₹40,000", "₹80,000", "₹1,60,000", "₹3,20,000"
    };

    public static void main(String[] args) {
        try {
            List<Question> questions = QuizService.fetchQuestions();
            Scanner scanner = new Scanner(System.in);
            int score = 0;

            System.out.println("🎬 Welcome to...");
            System.out.println("""
                     __      __       .__                                  __                                                                                                                     \s
                    /  \\    /  \\ ____ |  |   ____  ____   _____   ____   _/  |_  ____                                                                                                             \s
                    \\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\  \\   __\\/  _ \\                                                                                                            \s
                     \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/   |  | (  <_> )                                                                                                           \s
                      \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >  |__|  \\____/                                                                                                 \s
                           \\/       \\/          \\/            \\/     \\/                                                                                                               \s
                     ____  __.  _____   ____ __________     __________    _____    _______  ___________ ________    _____     .____       _____   ____  __.___ _____________  ________________.___\s
                    |    |/ _| /  _  \\ |    |   \\      \\    \\______   \\  /  _  \\   \\      \\ \\_   _____//  _____/   /  _  \\    |    |     /  _  \\ |    |/ _/   |   \\______   \\/  _  \\__    ___/|   |
                    |      <  /  /_\\  \\|    |   /   |   \\    |    |  _/ /  /_\\  \\  /   |   \\ |    __)_/   \\  ___  /  /_\\  \\   |    |    /  /_\\  \\|      </    ~    \\     ___/  /_\\  \\|    |   |   |
                    |    |  \\/    |    \\    |  /    |    \\   |    |   \\/    |    \\/    |    \\|        \\    \\_\\  \\/    |    \\  |    |___/    |    \\    |  \\    Y    /    |  /    |    \\    |   |   |
                    |____|__ \\____|__  /______/\\____|__  /   |______  /\\____|__  /\\____|__  /_______  /\\______  /\\____|__  /  |_______ \\____|__  /____|__ \\___|_  /|____|  \\____|__  /____|   |___|
                            \\/       \\/                \\/           \\/         \\/         \\/        \\/        \\/         \\/           \\/       \\/        \\/     \\/                 \\/             \s
                    """);
            System.out.println("Hosted by: 👤 Helal Anwar!\n");
            System.out.println("Let's begin the game...\n");

            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
                System.out.println("🔔 Question " + (i + 1) + " for " + PRIZES[i]);
                System.out.println("🧠 " + q.getQuestion());

                List<String> options = q.getOptions();
                for (int j = 0; j < options.size(); j++) {
                    System.out.println((char) ('A' + j) + ". " + options.get(j));
                }

                System.out.print("\n👉 Your answer (A/B/C/D): ");
                String input = scanner.nextLine().trim().toUpperCase();
                int index = input.charAt(0) - 'A';

                System.out.println("🔒 Lock kiya jaaye? (Y/N): ");
                String lock = scanner.nextLine().trim().toUpperCase();
                if (!lock.equals("Y")) {
                    System.out.println("⏩ Skipping the question...");
                    continue;
                }

                if (index >= 0 && index < options.size()) {
                    if (options.get(index).equals(q.getCorrectAnswer())) {
                        System.out.println("✅ Sahi Jawaab! Aap jeet te hain " + PRIZES[i]);
                        score++;
                    } else {
                        System.out.println("❌ Galat Jawaab! Sahi jawaab tha: " + q.getCorrectAnswer());
                        break;
                    }
                } else {
                    System.out.println("⚠️ Invalid option.");
                    break;
                }

                System.out.println("--------------------------------------------------\n");
            }

            System.out.println("🎉 Game Over! Aapka score hai: " + score + "/" + questions.size());
            if (score > 0) {
                System.out.println("🏆 Aap jeet te hain: " + PRIZES[score - 1]);
            } else {
                System.out.println("😢 Koi baat nahi, koshish jaari rakhiye.");
            }

        } catch (Exception e) {
            System.out.println("❗ Error: " + e.getMessage());
        }
    }
}
