## DataFormat

DateFormat 是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化并解析日期或时间。日期/时间格式化子类（如 SimpleDateFormat）允许进行格式化（也就是日期 -> 文本）、解析（文本-> 日期）和标准化。将日期表示为 `Date` 对象，或者表示为从 GMT（格林尼治标准时间）1970 年 1 月 1 日 00:00:00 这一刻开始的毫秒数。

输出使用：

```java
myString=DataFormat.getDataInstance().format(myData);
```

解析使用：

```java
myData=DataFormat.getDtaInstance().parse(myString);
```

