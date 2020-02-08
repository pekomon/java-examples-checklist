package patterns;


class Person {

    private int id;
    private String name;
    private int age;
    private String address;

    private Person(final int pId, final String pName, final int pAge, final String pAddress) {
        this.id = pId;
        this.name = pName;
        this.age = pAge;
        this.address = pAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Person with ID number " + id + " ");
        if (name != null) {
            sb.append("has name " + name + " ");
        }
        if (age >= 0) {
            sb.append("is " + age + " years old " );
        }
        if (address != null) {
            sb.append("lives in " + address);
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public static class PersonBuilder {

        private String name;
        private int age = -1;
        private String address;

        public PersonBuilder setName(final String pName) {
            this.name = pName;
            return this;
        }

        public PersonBuilder setAge(final int pAge) {
            this.age = pAge;
            return this;
        }

        public PersonBuilder setAddress(final String pAddress) {
            this.address = pAddress;
            return this;
        }

        public Person build(final int pId) {
            return new Person(pId, name, age, address);
        }
    }
}

public class FluentBuilder {

    public static void main(String[] args) {
        Person person1 = new Person.PersonBuilder()
                .setAddress("Home Street 123")
                .build(1);
        System.out.println(person1);
        Person person2 = new Person.PersonBuilder()
                .setName("John Smith")
                .setAge(32)
                .setAddress("324 Street, NY")
                .build(2);
        System.out.println(person2);
    }
}
