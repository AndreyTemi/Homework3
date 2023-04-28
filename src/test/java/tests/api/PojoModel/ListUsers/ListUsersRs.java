package tests.api.PojoModel.ListUsers;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUsersRs {

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<resourseModel> getData() {
        return data;
    }

    public void setData(ArrayList<resourseModel> data) {
        this.data = data;
    }

    Integer page, per_page, total, total_pages;

    public SupportModel getSupport() {
        return support;
    }

    public void setSupport(SupportModel support) {
        this.support = support;
    }

    SupportModel support;
    ArrayList<resourseModel> data;

}
