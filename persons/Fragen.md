Den Code zu den Fragen finden Sie in der Datei `PersonsTest.java`.

## super

1. Welche Oberklassen hat `Teacher`?

2. Warum darf Teacher Charlie in `PersonsTest.java` in einer Variablen vom Typ `Person` gespeichert werden?

3. Schauen Sie sich an, welche Ausgabe der Konstruktoraufruf von für Charlie macht. Können Sie im Code nachvollziehen, was passiert? Was macht das Statement `super(name, mail, salary)`?

4. Die `toString`-Methode welcher Klasse ruft `System.out.println(charlie)` auf? `Object`, `Person`, `Employee` oder `Teacher`? Warum?

5. Was macht das Statement `super.toString()` in der Klasse `Teacher`?

## equals

6. in der `PersonsTest.java`: Die `equals`-Methode welcher Klasse wird aufgerufen? `Object`, `Person` oder `Student`?

7. Warum sind Sascha und Alex an dieser Stelle gleich?

8. in der Klasse `Student`: Haben Sie eine Vermutung, woher die Variable `student` in `return this.studentNumber == student.studentNumber;` kommt?

## this

9. Können Konstruktoren überladen werden? Schauen Sie sich die Klasse `Student` an.

10. Was macht `this(name, mail, INVALID_STUDENT_NUMBER);` im zweiten Konstruktor von `Student`? Was wird da aufgerufen?

## Konstruktoren

11. Inwiefern werden Konstruktoren vererbt? Funktioniert die auskommentierte Codezeile in der `PersonsTest.java`, um Martin zu erstellen?

## static

12. Wie können wir auf statische Variablen zugreifen? Welche der vier Zeilen in `PersonsTest` funktioniert? Wird das ausgegeben, was sie erwartet haben?

13. Welche Variante finden Sie am eindeutigsten?

## Methodenaufrufe

14. Warum kann in der Klasse `Employee` die Methode `richerPerson` auf `salary` zugfreifen? Das Feld ist doch eigentlich `private`? (Oder ist das hier egal?)

15. Welche der vorgegebenen Aufrufe von `richerPerson` funktionieren? Warum? (Ergibt das intuitiv Sinn? Ergibt das aus Java-Sicht Sinn? Denken Sie an actual und declared Types.)
