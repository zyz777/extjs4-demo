package com.zyz.extjs.entity;

public class Response {
        private boolean success = true;
        private int total;
        private Object data;

        public Response(int total, Object data) {
            this.total = total;
            this.data = data;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }