# Java software development
## Laboratory work 5
### Inheritance and polymorphism

---

## Author
**Mykola Kushnir** <code>[mkushnir885](https://github.com/mkushnir885)</code>, [KPI](https://kpi.ua/) [FICE](https://fiot.kpi.ua/) student of the **IM-22** group

## Variant
Number in the group list: **13**
- C<sub>13</sub> = 13 % 13 = 0

## How to run

1. Navigate to the location on your machine where you want to clone this repository folder:
```bash
cd /desired/location
```

2. Clone this repository folder to desired location on your machine (copy and paste this long command into the terminal):
```bash
git init &&
git remote add origin https://github.com/mkushnir885/java-labs &&
git config core.sparseCheckout true &&
echo "5" >> .git/info/sparse-checkout &&
git pull origin main
```

3. Go inside the laboratory work directory:
```bash
cd 5
```

4. Make sure [Apache Maven](https://maven.apache.org) is properly installed:
```bash
mvn --version
```

5. Compile and run the source code:
```bash
mvn clean compile exec:java
```
