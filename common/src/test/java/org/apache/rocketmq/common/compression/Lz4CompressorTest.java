package org.apache.rocketmq.common.compression;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertArrayEquals;

public class Lz4CompressorTest {

    @Test
    public void testCompressAndDecompress() throws IOException {
        // Arrange
        Lz4Compressor lz4Compressor = new Lz4Compressor();

        byte[] originalData = "Hello, this is some test data.".getBytes();

        // Act
        byte[] compressedData = lz4Compressor.compress(originalData, 5);
        byte[] decompressedData = lz4Compressor.decompress(compressedData);

        // Assert
        assertArrayEquals(originalData, decompressedData);
    }
}

