/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.list;

import org.cactoos.CountOf;
import org.cactoos.ScalarHasValue;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Test case for {@link ArrayOf}.
 * @author Yegor Bugayenko (yegor256@gmail.com)
 * @author Ix (ixmanuel@yahoo.com)
 * @version $Id$
 * @since 0.12
 * @checkstyle JavadocMethodCheck (500 lines)
 */
public final class ArrayOfTest {

    @Test
    public void convertsScalarsToIterable() {
        MatcherAssert.assertThat(
            "Can't convert scalars to iterable",
            new CountOf(
                new ArrayOf<>(
                    "a", "b", "c"
                )
            ),
            // @checkstyle MagicNumber (1 line)
            new ScalarHasValue<>(3)
        );
    }

    @Test
    public void convertsObjectsToIterable() {
        MatcherAssert.assertThat(
            "Can't convert objects to iterable",
            new CountOf(
                new ArrayOf<>(
                    new TextOf("a"), new TextOf("b"), new TextOf("c")
                )
            ),
            // @checkstyle MagicNumber (1 line)
            new ScalarHasValue<>(3)
        );
    }

    @Test
    public void convertsMapToIterable() {
        final String expected = "hello, ";
        MatcherAssert.assertThat(
            "Can't flat a map into an interable of values",
            new ItemOfIterable<>(
                new ArrayOf<>(
                    new MapOf<Integer, String>(
                        new MapEntry<>(0, expected),
                        new MapEntry<>(1, "world!")
                    )
                ),
                0
            ),
            new ScalarHasValue<>(
                expected
            )
        );
    }

}

