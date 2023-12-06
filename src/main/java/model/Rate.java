package model;

import java.time.LocalDateTime;

public record Rate(Double Value, LocalDateTime Date) {
    @Override
    public String toString() {
        return String.valueOf(this.Value);
    }
}
