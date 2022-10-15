package com.woquiz.common.utils;

import java.util.List;
import java.util.function.Supplier;

public class BasicUtils {

    public static class ConditionalList<T> {
        private List<T> list;

        public ConditionalList(List<T> list) {
            this.list = list;
        }

        public static <T> ConditionalList<T> of(List<T> list) {
            return new ConditionalList<>(list);
        }

        public ConditionalList<T> add(boolean condition, Supplier<T> valueSupplier) {
            if (condition) {
                list.add(valueSupplier.get());
            }
            return this;
        }

        public ConditionalList<T> add(T t) {
            list.add(t);
            return this;
        }

        public List<T> toList() {
            return list;
        }

    }
}