package com.company;

//hashcode和equals改写的手写案例
public class hashEqualsDemo {
    private static class Person{
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj){
            if (obj == null){
                return false;
            }
            if (this == obj){
                return true;
            }
            if (this.getClass()!= obj.getClass()){
                return false;
            }
            Person person = (Person) obj;
            return this.name.equals(person.name) && this.age == (person.age);
        }

        @Override
        public int hashCode(){
            int namehash = name.toLowerCase().hashCode();
            return age^namehash;
        }
    }
    public static void main(String[] args){
        Person person1 = new Person(19, "miss wang");
        Person p2 = new Person(19, "miss wang");
        System.out.println(person1==p2);
        System.out.println(person1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(person1.equals(p2));
    }

}
