package org.example.models;


public class Employee {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private Department department;

        public Employee() {
        }

        public int getId() {
                return this.id;
        }

        public String getFirstName() {
                return this.firstName;
        }

        public String getLastName() {
                return this.lastName;
        }

        public String getEmail() {
                return this.email;
        }

        public Department getDepartment() {
                return this.department;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setDepartment(Department department) {
                this.department = department;
        }

        public boolean equals(final Object o) {
                if (o == this) return true;
                if (!(o instanceof Employee)) return false;
                final Employee other = (Employee) o;
                if (!other.canEqual((Object) this)) return false;
                if (this.getId() != other.getId()) return false;
                final Object this$firstName = this.getFirstName();
                final Object other$firstName = other.getFirstName();
                if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName))
                        return false;
                final Object this$lastName = this.getLastName();
                final Object other$lastName = other.getLastName();
                if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName))
                        return false;
                final Object this$email = this.getEmail();
                final Object other$email = other.getEmail();
                if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
                final Object this$department = this.getDepartment();
                final Object other$department = other.getDepartment();
                if (this$department == null ? other$department != null : !this$department.equals(other$department))
                        return false;
                return true;
        }

        protected boolean canEqual(final Object other) {
                return other instanceof Employee;
        }

        public int hashCode() {
                final int PRIME = 59;
                int result = 1;
                result = result * PRIME + this.getId();
                final Object $firstName = this.getFirstName();
                result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
                final Object $lastName = this.getLastName();
                result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
                final Object $email = this.getEmail();
                result = result * PRIME + ($email == null ? 43 : $email.hashCode());
                final Object $department = this.getDepartment();
                result = result * PRIME + ($department == null ? 43 : $department.hashCode());
                return result;
        }

        public String toString() {
                return "Employee(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", department=" + this.getDepartment() + ")";
        }

        // Constructors, getters, and setters
        // ...
    }


