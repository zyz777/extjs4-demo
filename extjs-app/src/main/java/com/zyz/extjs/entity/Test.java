package com.zyz.extjs.entity;

public class Test {
        private int id;
        private String TestName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTestName() {
            return TestName;
        }

        public void setTestName(String testName) {
            TestName = testName;
        }

        public Test(int id, String testName) {
            this.id = id;
            TestName = testName;
        }

        public Test() {
        }
    }