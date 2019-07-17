[数据结构和算法](https://github.com/ChinesePowerful/algorithm)
=======

### 简介
- **数据结构** 是由「相互之间存在着一种或多种关系的数据元素的集合」和「该集合中数据元素之间的关系」组成的
- **算法** 是指解题方案的准确而完整的描述，是一系列解决问题的清晰指令，算法代表着用系统的方法描述解决问题的策略机制

## 使用到的 Java 特性

### 泛型
- 集合类的抽象数据类型的一个关键特性是我们应该可以使用它们存储任意类型的数据
- 一种特殊的 Java 机制能够做到这一点，它被称之为 **泛型**

### 迭代器
- 对于许多应用场景，用例的要求只是用某种方式处理集合中的每个元素，或者叫做迭代访问集合中的所有元素
- 我们可以让我们的集合类实现 Iterator接口，使得集合支持迭代

### 比较和交换
- 待排序的元素需要实现 Java 的 Comparable 接口，该接口有 compareTo() 方法，可以用它来判断两个元素的大小关系
- 使用辅助函数 less() 和 swap() 来进行比较和交换的操作，使得代码的可读性和可移植性更好
- 排序算法的成本模型是比较和交换的次数

## 数据结构

[1.背包、队列和栈（Bag Queue Stack）](https://github.com/ChinesePowerful/algorithm/tree/master/src/data_structure/bag_queue_stack)

[2.优先队列（Priority Queue）](https://github.com/ChinesePowerful/algorithm/tree/master/src/data_structure/priority_queue)



## 算法

### 常见算法

[1.二分查找（Binary Search）](https://github.com/ChinesePowerful/algorithm/tree/master/src/algorithm/binary_search)

### 排序算法

[1.冒泡排序（Bubble Sort）](https://github.com/ChinesePowerful/algorithm/tree/master/src/algorithm/sort)

[2.选择排序（Select Sort）](https://github.com/ChinesePowerful/algorithm/tree/master/src/algorithm/sort)

[3.插入排序（Insert Sort）](https://github.com/ChinesePowerful/algorithm/tree/master/src/algorithm/sort)

[4.希尔排序（Shell Sort）](https://github.com/ChinesePowerful/algorithm/tree/master/src/algorithm/sort)

[5.归并排序（Merge Sort）](https://github.com/ChinesePowerful/algorithm/tree/master/src/algorithm/sort)

[6.快速排序（Quick Sort）](https://github.com/ChinesePowerful/algorithm/tree/master/src/algorithm/sort)