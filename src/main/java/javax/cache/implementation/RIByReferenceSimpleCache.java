/**
 *  Copyright 2011 Terracotta, Inc.
 *  Copyright 2011 Oracle America Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package javax.cache.implementation;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The reference implementation for JSR107.
 * <p/>
 * This is meant to act as a proof of concept for the API. It is not threadsafe or high performance. It therefore is
 * not suitable for use in production. Please use a production implementation of the API.
 * <p/>
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values*
 * @author Yannis Cosmadopoulos
 */
class RIByReferenceSimpleCache<K, V> implements RISimpleCache<K, V> {
    private final ConcurrentHashMap<K, V> store = new ConcurrentHashMap<K, V>();

    /**
     * {@inheritDoc}
     */
    public boolean containsKey(Object key) {
        return store.containsKey(key);
    }

    /**
     * {@inheritDoc}
     */
    public void put(K key, V value) {
        store.put(key, value);
    }

    /**
     * {@inheritDoc}
     */
    public void putAll(Map<? extends K, ? extends V> map) {
        store.putAll(map);
    }

    /**
     * {@inheritDoc}
     */
    public boolean putIfAbsent(K key, V value) {
        return store.putIfAbsent(key, value) == null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean remove(Object key) {
        return store.remove(key) != null;
    }

    /**
     * {@inheritDoc}
     */
    public V getAndRemove(Object key) {
        return store.remove(key);
    }

    /**
     * {@inheritDoc}
     */
    public boolean replace(K key, V oldValue, V newValue) {
        return store.replace(key, oldValue, newValue);
    }

    /**
     * {@inheritDoc}
     */
    public boolean replace(K key, V value) {
        return store.replace(key, value) != null;
    }

    /**
     * {@inheritDoc}
     */
    public V getAndReplace(K key, V value) {
        return store.replace(key, value);
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return store.size();
    }

    /**
     * {@inheritDoc}
     */
    public void removeAll() {
        store.clear();
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<Map.Entry<K, V>> iterator() {
        return store.entrySet().iterator();
    }

    /**
     * {@inheritDoc}
     */
    public V get(Object key) {
        return store.get(key);
    }
}
