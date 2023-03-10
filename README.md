# Объектно-ориентированное программирование (ООП)

> Это парадигма (стиль, шаблон) разработки ПО, <br>
> основными понятиями которой являются классы и объекты. <br>
> Говорят, что разработка в стиле ООП ведется с использованием классов объектов, <br>
> которые обладают состоянием и поведением, зависящим от этого состояния.
___

## Домашнее задание
___
### Домашнее задание 1

Реализовать, с учетом ооп подхода, приложение.

Для проведения исследований с генеалогическим древом.

Идея: описать некоторое количество компонент, например:

модель человека и дерева

Под “проведением исследования” можно понимать получение всех детей выбранного человека.

### Домашнее задание 2

___

В проекте с гениалогическим древом подумайте и используйте интерфейсы.

Дополнить проект методами записи в файл и чтения из файла. 

Для этого создать отдельный класс и реализовать в нем нужные методы. Для данного класса сделайте интерфейс, который и используйте в своей программе. 

Например в классе дерева в качестве аргумента метода save передавайте не конкретный класс, а объект интерфейса, с помощью которого и будет происходить запись. 

### Домашнее задание 3

___

Продолжаем работать с проектом с семейным деревом.

Реализовать интерфейс Iterable для дерева.

Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения
___

## Лекции
___

### Лекция 1

___

*Принципы ООП: Инкапсуляция, наследование, полиморфизм*

***Ex001***

Рассчитать расстояние между 2 точками с координатами (0,0) и (0,1)
* Math.sqrt 
* Math.pow

***Ex002***

Рассчитать расстояние между 2 точками с координатами (0,2) и (0,10), создать class Point2D

***Ex003***

Добавить в class Point2D:
* геттеры и сеттеры
* методы toString() и distance(Point2D a, Point2D b)
* конструкторы (ctor - для быстрого создания) с вводом 0, 1 и 2 координами
* собственную документацию для конструкторов (через /** */)

***Ex004***

**Инкапсуляция** – это свойство системы, позволяющее объединить данные и методы, работающие с ними в классе, скрыв детали реализации и защитив от пользователя этого класса объектов.

Провести инкапсуляцию для класса Робот

***Ex005***

* class Magician (Маг)
* class Pries (жрец)

***Ex006***

class BaseHero

class Magician extends BaseHero

class Priest extends BaseHero

**Полиморфизм** – возможность положить в экземпляр базового класса любого из его производных
___

### Лекция 2

___

**Абстракция** – это свойство системы, позволяющее описать общие характеристики базового класса для всех его производных классов, а наполнение деталями предоставляется каждому из этих классов.

В абстрактном классе определяются лишь общие поля и характер методов, которые должны быть конкретно реализованы в производных классах, а не в самом базовом классе.

**interface** предназначен для описания исключительно общего поведения сущностей.

Частный случай: для гарантии, реализации некоторого поведения.

Аналогичен абстрактному классу со всеми абстрактными методами, но допускается множественное наследование

*implements Saveable, Serializable*

