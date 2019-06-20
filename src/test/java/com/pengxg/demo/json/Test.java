package com.pengxg.demo.json;


import cn.hutool.json.JSONObject;

import java.util.Arrays;

public class Test {

    public static void main(String... args) {
        String response = "{\n" +
                "    \"status\": \"completed\",\n" +
                "    \"start_date\": \"2019-03-11 00:00:00\",\n" +
                "    \"end_date\": \"2019-03-11 23:59:00\",\n" +
                "    \"submitted\": \"2019-03-12 11:32:50 UTC\",\n" +
                "    \"token\": \"3A43CB8CC9EF6AEC00181B8AA0A41309\",\n" +
                "    \"size\": \"24824839\",\n" +
                "    \"url\": \"https://app.ravenpack.com/downloads/getfile?id=3A43CB8CC9EF6AEC00181B8AA0A41309\",\n" +
                "    \"checksum\": \"1d88ab64508bdaf979173e56498d9658\",\n" +
                "    \"tags\": []\n" +
                "}";

        Job job = new JSONObject(response).toBean(Job.class);
        System.out.println(job.toString());

    }

    class Job {
        private String status;
        private String start_date;
        private String end_date;
        private String submitted;
        private String token;
        private Integer size;
        private String url;
        private String checksum;
        private String[] tags;

        public Job() {
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStart_date() {
            return this.start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public String getEnd_date() {
            return this.end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }

        public String getSubmitted() {
            return this.submitted;
        }

        public void setSubmitted(String submitted) {
            this.submitted = submitted;
        }

        public String getToken() {
            return this.token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Integer getSize() {
            return this.size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getChecksum() {
            return this.checksum;
        }

        public void setChecksum(String checksum) {
            this.checksum = checksum;
        }

        public String[] getTags() {
            return this.tags;
        }

        public void setTags(String[] tags) {
            this.tags = tags;
        }

        public String toString() {
            return "Job{status='" + this.status + '\'' + ", start_date='" + this.start_date + '\'' + ", end_date='" + this.end_date + '\'' + ", submitted='" + this.submitted + '\'' + ", token='" + this.token + '\'' + ", size=" + this.size + ", url='" + this.url + '\'' + ", checksum='" + this.checksum + '\'' + ", tags=" + Arrays.toString(this.tags) + '}';
        }
    }
}
