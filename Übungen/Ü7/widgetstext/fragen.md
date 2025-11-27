
1. Welche Unterklassen von `Widget` gibt es? Geben Sie auch die Klassen an, die nicht *direkt* von `Widget` erben.

Die direkten Unterklassen von Widget sind Layout, Label und Button. Die indirekten Unterklassen sind VerticalLayout und HorizontalLayout (erben von Layout), sowie UnderlinedLabel (erbt von Label).

2. Wenn Sie das Programm ausführen, wird mehrere Male `new widget constructed` ausgegeben (durch das `println` im `Widget`-Konstruktor). Wir rufen aber nie `new Widget()` auf. Warum gibt es die Ausgabe trotzdem?

Die Ausgabe "new widget constructed" erscheint, weil jede Erstellung einer Subklasse von Widget (wie Label, Button oder Layout) implizit den Konstruktor der Superklasse Widget aufruft, auch wenn nie direkt new Widget() verwendet wird.

3. Warum ist das Statement `Layout verticalLayout = new VerticalLayout();` in der `Application`-Klasse gültig?
Müsste es nicht `VerticalLayout verticalLayout = new VerticalLayout();` heißen?

Das Statement ist gültig, weil VerticalLayout eine Subklasse von Layout ist und durch Polymorphie ein VerticalLayout-Objekt als Layout referenziert werden kann.

4. Wie lautet der declared Type der Variable `verticalLayout` an dieser Stelle? Was ist der actual Type des Objekts, das von der Variablen referenziert wird?

- Declared Type: Layout
- Actual Type: VerticalLayout


5. Warum funktioniert `verticalLayout.add(new Label("Hello World!"));` in der `Application`-Klasse?
Es gibt doch weder in `Layout`, noch in `VerticalLayout` eine `add`-Methode, die ein `Label` als Parameter nimmt. (Oder doch?)

Es funktioniert, weil verticalLayout ein VerticalLayout-Objekt referenziert, das von Layout erbt, und Layout die Methode add(Widget widget) definiert, wobei Label eine Subklasse von Widget ist.

6. In der Klasse `Layout` ist die Instanzvariable `widgets` als `final` deklariert. Warum funktioniert `widgets.add(widget)` in der Methode `add`?
Durch den Aufruf wird `widgets` verändern, aber sollte `final` nicht dafür sorgen, dass die Variable `widgets` nicht mehr geändert werden kann?

final verhindert nur die Neuzuweisung der Referenz widgets selbst, nicht jedoch die Veränderung des Objekts, auf das widgets verweist – daher kann widgets.add(widget) den Inhalt der Liste ändern.

7. Schauen Sie sich die Klasse `AppTest` an. Warum funktioniert `widget.numberOfWidgets()` nicht?
In `widget` ist doch weiterhin ein `VerticalLayout`-Objekt gespeichert.

Es funktioniert nicht, weil widget vom Typ Widget ist und numberOfWidgets() nur in Layout definiert ist, was nicht im Typ Widget sichtbar ist – Polymorphie erlaubt nur Aufrufe von Methoden des declared Typs.

8. Kann man in der `draw`-Methode der Klasse `Button` `if(enabled) { ... }` schreiben? Warum (nicht)?

Ja, man kann if(enabled) { ... } schreiben, da enabled eine Instanzvariable ist und in der Subklasse Button zugänglich, aber es wäre besser, isEnabled() zu verwenden, um den Getter zu nutzen.

9. Warum muss die Klasse `Widget` als `abstract` deklariert werden? Oder anders gefragt: Warum darf man nicht `public class Widget` schreiben?

Widget muss abstract sein, weil es abstrakte Methoden wie getHeight(), getWidth() und draw() deklariert, die in Subklassen implementiert werden müssen – ohne abstract würde der Compiler eine Instanziierung erlauben, was zu Fehlern führen würde.

10. Warum muss die Klasse `Layout` als `abstract` deklariert? Sie enthält doch gar keine abstrakte Methode? (Oder doch?)

Layout muss abstract sein, weil es von Widget erbt und die abstrakten Methoden getHeight(), getWidth() und draw() nicht implementiert, sondern diese an Subklassen wie VerticalLayout delegiert.

11. In der Klasse `Widget` ist die Methode `toString` mit `@Override` annotiert, obwohl `Widget` gar kein `extends` verwendet.
Die `toString`-Methode welcher Klasse überschreibt `Widget`?

Widget.toString() überschreibt die toString()-Methode der Klasse Object, von der alle Java-Klassen implizit erben.

12. Warum muss `Widget.toString()` `public` sein, aber `VerticalLayout.getWidth()` z. B. nicht? In beiden Fällen werden doch einfach nur Methoden überschrieben?

Widget.toString() muss public sein, weil es die public Methode aus Object überschreibt und die Sichtbarkeit nicht reduzieren darf; VerticalLayout.getWidth() überschreibt eine package-private Methode aus Widget, daher reicht package-private Sichtbarkeit.

13. Was bedeutet das `\n` in der `toString`-Methode von `Layout`?

\n ist ein Escape-Sequenz für einen Zeilenumbruch (newline), der in der String-Ausgabe eine neue Zeile erzeugt, um die Kind-Widgets lesbar untereinander darzustellen.

14. Wie würde sich das Verhalten des Programms verändern, wenn wir `@Override` überall entfernen?

Das Entfernen von @Override würde das Programm weiterhin kompilieren und ausführen, da die Annotation optional ist, aber es würde keine Kompilierungsfehler bei fehlerhaften Überschreibungen (z.B. Tippfehler im Methodennamen) melden, was zu subtilen Bugs führen könnte.

15. Warum kann die Methode `toString` in `Widget` die Methode `getWidth()` aufrufen?
Die Methode `getWidth()` hat doch gar keine Implementierung? (Oder doch?)

Widget.toString() kann getWidth() aufrufen, weil zur Laufzeit das tatsächliche Objekt (z.B. ein Label oder Layout) eine Implementierung von getWidth() bereitstellt – durch Polymorphie wird die Methode der Subklasse aufgerufen.

16. Die Klasse `Label` verwendet in Ihrer `draw`-Methode den ternären Operator.
Wie könnte `StdDraw.setPenColor(isEnabled() ? StdDraw.BLACK : StdDraw.GRAY);` alternativ mit einer if-Verzweigung ausgedrückt werden?

Alternativ: if (isEnabled()) { StdDraw.setPenColor(StdDraw.BLACK); } else { StdDraw.setPenColor(StdDraw.GRAY); }
