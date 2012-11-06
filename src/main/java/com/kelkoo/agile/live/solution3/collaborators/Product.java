package com.kelkoo.agile.live.solution3.collaborators;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = -440117090747421807L;
    
    private final String name;
    private final float price;

    public Product(String name, float prix) {
        this.name = name;
        this.price = prix;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Float.floatToIntBits(price);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
            return false;
        return true;
    }

}
