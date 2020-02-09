package patterns;

/**
 * Fluent builder propagating through inheritance hierarchy using recursive generic definition.
 */

class Human {

    public String name;
    public int age;
    public String school;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Person " + name + " ");
        sb.append("is " + age + " years old ");
        if (school != null) {
            sb.append("studies in " + school);
        }

        sb.append(System.lineSeparator());
        return sb.toString();
    }
}

/**
 * HumanBuilder class takes type argument that extends HumanBuilder.
 * Later on inheriting classes use inheritor as type argument. Like in StudentBuilder
 */
class HumanBuilder<SELF extends HumanBuilder<SELF>> {

    protected Human human = new Human();

    public SELF setName(final String pName) {
        human.name = pName;
        return self();
    }

    public SELF setAge(final int pAge) {
        human.age = pAge;
        return self();
    }

    protected SELF self() {
        // Idea nags but there can't be a case where SELF doesn't extend HumanBuilder
        return (SELF) this;
    }

    public Human build() {
        return human;
    }
}

class StudentBuilder extends HumanBuilder<StudentBuilder> {

    public StudentBuilder studiesAt(final String pSchool) {
        human.school = pSchool;
        return this;
    }

    @Override
    protected StudentBuilder self() {
        return this;
    }
}

public class GenericsBuilder {

    public static void main(String[] args) {

        // Now it is possible to use both StudentBuilder and HumanBuilder

        Human human1 = new StudentBuilder()
                .setName("Jack Jackson")
                .setAge(21)
                .studiesAt("MIT")
                .build();
        System.out.println(human1);

        HumanBuilder hb = new HumanBuilder()
                .setName("John Johnson")
                .setAge(34);
        System.out.println(hb.build());

        StudentBuilder sb = new StudentBuilder()
                .setName("Mr. Anderson")
                .setAge(98);
        System.out.println(sb.build());
    }
}
