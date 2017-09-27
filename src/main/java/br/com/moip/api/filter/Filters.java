package br.com.moip.api.filter;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Filters {

    private ArrayList<String> filters = new ArrayList<>();

    public Filters greaterThan(String field, String value) {
        filters.add(String.format("%s::gt(%s)", field, value));

        return this;
    }

    public Filters greaterThanOrEqual(String field, String value)
    {
        filters.add(String.format("%s::ge(%s)", field, value));

        return this;
    }

    public Filters lessThan(String field, String value) {
        filters.add(String.format("%s::lt(%s)", field, value));

        return this;
    }

    public Filters between(String field, String value1, String value2) {
        filters.add(String.format("%s::bt(%s,%s)", field, value1, value2));

        return this;
    }

    public Filters in (String field, ArrayList<String>values) {
        filters.add(String.format("%s::in(%s)", field, StringUtils.join(values, ",")));

        return this;
    }

    @Override
    public String toString() {
        return StringUtils.join(filters, "|");
    }

}
