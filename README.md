# innopolis-university-course

<div>
<h3>ДЗ_2</h3>
Задание 1. Написать программу ”Hello, World!”. В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.

Смоделировав ошибку «NullPointerException»
Смоделировав ошибку «ArrayIndexOutOfBoundsException»
Вызвав свой вариант ошибки через оператор throw


Задание 2. Составить программу, генерирующую N случайных чисел. Для каждого числа k вычислить квадратный корень q. Если квадрат целой части q числа равен k, то вывести это число на экран. Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.


Задание 3. Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100), sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка). Создать два класса, методы которых будут реализовывать сортировку объектов. Предусмотреть единый интерфейс для классов сортировки. Реализовать два различных метода сортировки этого массива по правилам:
первые идут мужчины
выше в списке тот, кто более старший
имена сортируются по алфавиту
Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
Предусмотреть генерацию исходного массива (10000 элементов и более).
Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.
</div>
<div>
<h3>ДЗ_3</h3>
Задание 1. Написать класс MathBox, реализующий следующий функционал:

Конструктор на вход получает массив Number. Элементы не могут повторяться. Элементы массива внутри объекта раскладываются в подходящую коллекцию (выбрать самостоятельно).
Существует метод summator, возвращающий сумму всех элементов коллекции.
Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель, являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления.
Необходимо правильно переопределить методы toString, hashCode, equals, чтобы можно было использовать MathBox для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap). Выполнение контракта обязательно!
Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.


Задание 2. Создать класс ObjectBox, который будет хранить коллекцию Object.
У класса должен быть метод addObject, добавляющий объект в коллекцию.
У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции и при наличии удаляющий его.
Должен быть метод dump, выводящий содержимое коллекции в строку.


Задание 3. Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox. Необходимо сделать такую связь, правильно распределить поля и методы. Функциональность в целом должна сохраниться. При попытке положить Object в MathBox должно создаваться исключение.
</div>
<div>
ДЗ_4
Разработать программу – картотеку домашних животных. У каждого животного есть уникальный идентификационный номер, кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.

Реализовать:

метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
поиск животного по его кличке (поиск должен быть эффективным)
изменение данных животного по его идентификатору
вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
</div>
<div>
<h4>Общие критерии оценки:</h4>
Программа компилируется.
В ходе работы программе не возникает ошибок в процессе выполнения, за исключением, где это необходимо.
Программа в результате своей работы возвращает корректный результат, т.е. тот который требуется по условиям задания.
Выполнены все архитектурные принципы построения программы, правильно применены принципы ООП.
Присутствует документация (JavaDoc).
Код соответствует принципам Java Code Convention.
Работа с ресурсами (файлы, потоки и т.д.) осуществляется корректно.
В программе предусмотрено возникновение исключительных ситуаций.
Код программы, без лишних локальных файлов, должен быть загружен в открытый репозиторий (github, bitbucket, gitlab).
Решение задачи оформляется в пакете с номером задания, например part1.lesson01.task01. В системе Moodle размещается ссылка на пакет с решением в репозитории.
</div>