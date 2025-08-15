# 🎯 Kaun Banega Lakhpati Quiz App

A Java-based quiz application inspired by the popular game show "Kaun Banega Crorepati" (Who Wants to be a Millionaire). Test your knowledge with trivia questions fetched from the Open Trivia Database and win virtual prizes!

## 🌟 Features

- **Interactive Quiz Experience**: Play through 10 progressive questions with increasing prize values
- **Live API Integration**: Questions fetched dynamically from the Open Trivia Database (OpenTDB)
- **Multi-language Support**: Questions and interface in both English and Hindi
- **Prize Progression**: Win virtual prizes from ₹1,000 up to ₹3,20,000
- **Lock Answer System**: Confirm your answers before submission
- **Formatted Output**: Beautiful ASCII art and emoji-rich interface
- **HTML Entity Decoding**: Properly formatted questions with special characters

## 🎮 Game Rules

1. Answer 10 multiple-choice questions correctly to win the maximum prize
2. Each correct answer advances you to the next prize level
3. One wrong answer ends the game
4. You can skip questions (but won't advance in prize money)
5. Must "lock" your answer to proceed

## 💰 Prize Structure

| Question | Prize Money |
|----------|-------------|
| 1        | ₹1,000      |
| 2        | ₹2,000      |
| 3        | ₹3,000      |
| 4        | ₹5,000      |
| 5        | ₹10,000     |
| 6        | ₹20,000     |
| 7        | ₹40,000     |
| 8        | ₹80,000     |
| 9        | ₹1,60,000   |
| 10       | ₹3,20,000   |

## 🛠️ Technical Stack

- **Language**: Java 24
- **Build Tool**: Maven
- **Dependencies**:
  - `org.json:json:20250517` - JSON parsing
  - `org.apache.commons:commons-text:1.14.0` - HTML entity decoding
- **API**: Open Trivia Database (https://opentdb.com/)

## 📋 Prerequisites

- Java JDK 24 or higher
- Maven 3.6+
- Internet connection (for fetching questions from API)

## 🚀 Installation & Setup

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd task8
   ```

2. **Build the project**:
   ```bash
   mvn clean compile
   ```

3. **Run the application**:
   ```bash
   mvn exec:java -Dexec.mainClass="org.helal_anwar.QuizApp"
   ```

   Or alternatively:
   ```bash
   java -cp target/classes:target/dependency/* org.helal_anwar.QuizApp
   ```

## 🎯 How to Play

1. Run the application
2. Read each question carefully
3. Select your answer by typing the corresponding letter (A, B, C, or D)
4. For multiple answers, separate with commas (e.g., "A,C")
5. Type "Y" to lock your answer or "N" to skip
6. Continue until you answer incorrectly or complete all 10 questions

### Example Gameplay:
```
🔔 Question 1 for ₹1,000
🧠 What is the capital of France?
A. London
B. Berlin
C. Paris
D. Madrid

👉 Your answer (e.g., A or A,C): C
🔒 Lock kiya jaaye? (Y/N): Y
✅ Sahi Jawaab! Aap jeet te hain ₹1,000
```

## 📁 Project Structure

```
src/
├── main/
│   └── java/
│       └── org/
│           └── helal_anwar/
│               ├── QuizApp.java      # Main application class
│               ├── QuizService.java  # API service for fetching questions
│               └── Question.java     # Question model class
└── test/
    └── java/                        # Test files (if any)
```

## 🏗️ Architecture

- **QuizApp**: Main class containing the game logic and user interface
- **QuizService**: Handles API communication with OpenTDB
- **Question**: Model class representing a quiz question with options and correct answers

## 🌐 API Integration

This app uses the [Open Trivia Database](https://opentdb.com/) API:
- **Endpoint**: `https://opentdb.com/api.php?amount=10&type=multiple`
- **Response Format**: JSON with question, correct answer, and incorrect options
- **Question Types**: Multiple choice only

## 🔧 Configuration

The app is pre-configured but you can modify:
- Number of questions by changing the API URL in `QuizService.java`
- Prize amounts in the `PRIZES` array in `QuizApp.java`
- Question categories by adding category parameters to the API URL

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**Helal Anwar**
- GitHub: [@helal_anwar](https://github.com/helal_anwar)

## 🙏 Acknowledgments

- Open Trivia Database for providing the quiz questions API
- Inspired by the popular TV show "Kaun Banega Crorepati"
- ASCII art generated for the welcome banner

## 🐛 Known Issues

- Requires active internet connection
- API rate limits may affect question fetching
- Questions are in English but interface includes Hindi text

## 🔮 Future Enhancements

- [ ] Add lifelines (50:50, Phone a Friend, etc.)
- [ ] Implement difficulty levels
- [ ] Add question categories selection
- [ ] Local question database fallback
- [ ] Score persistence and leaderboard
- [ ] GUI version using JavaFX or Swing
- [ ] Multiple language support for questions

---

🎉 **Happy Quizzing!** Test your knowledge and see how far you can go in this exciting quiz adventure!
