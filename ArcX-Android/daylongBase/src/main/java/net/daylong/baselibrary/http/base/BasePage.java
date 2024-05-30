package net.daylong.baselibrary.http.base;

import java.util.List;

public class BasePage<T> {

    private List<T> data;

    private MetaBean meta;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static class MetaBean {
        /**
         * page_num : 1
         * page_size : 20
         * item_count : 1
         * page_count : 1
         */

        private int page_num;
        private int page_size;
        private int item_count;
        private int page_count;

        public int getPage_num() {
            return page_num;
        }

        public void setPage_num(int page_num) {
            this.page_num = page_num;
        }

        public int getPage_size() {
            return page_size;
        }

        public void setPage_size(int page_size) {
            this.page_size = page_size;
        }

        public int getItem_count() {
            return item_count;
        }

        public void setItem_count(int item_count) {
            this.item_count = item_count;
        }

        public int getPage_count() {
            return page_count;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }


        /**

         * @return
         */
        public boolean isRefresh(){
            return page_num==1;
        }

        /**

         * @return
         */
        public boolean isCanLoadMore(){
            return page_num < page_count;
        }

    }

}
