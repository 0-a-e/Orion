package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.Tag;

public class ObjectTaggingXmlFactory {
    public byte[] convertToXmlByteArray(ObjectTagging objectTagging) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("Tagging").start("TagSet");
        for (Tag next : objectTagging.getTagSet()) {
            xmlWriter.start("Tag");
            xmlWriter.start("Key").value(next.getKey()).end();
            xmlWriter.start("Value").value(next.getValue()).end();
            xmlWriter.end();
        }
        xmlWriter.end();
        xmlWriter.end();
        return xmlWriter.getBytes();
    }
}
