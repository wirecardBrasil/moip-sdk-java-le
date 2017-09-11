package br.com.moip.resource;

import java.util.ArrayList;

public class ScopePermissionList extends ArrayList<ScopePermission> {

    public ScopePermissionList(ScopePermission... scopes) {
        for (ScopePermission scope : scopes) {
            this.add(scope);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0, il = this.size(); i < il; i++) {
            if (i > 0)
                sb.append(",");
            sb.append(this.get(i));
        }
        return sb.toString();
    }
}
