package kotlin.reflect.jvm.internal.impl.metadata;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class ProtoBuf {

    public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
    }

    public interface ClassOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface ConstructorOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface ContractOrBuilder extends MessageLiteOrBuilder {
    }

    public interface EffectOrBuilder extends MessageLiteOrBuilder {
    }

    public interface EnumEntryOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface ExpressionOrBuilder extends MessageLiteOrBuilder {
    }

    public interface FunctionOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface PackageFragmentOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface PackageOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface PropertyOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface QualifiedNameTableOrBuilder extends MessageLiteOrBuilder {
    }

    public interface StringTableOrBuilder extends MessageLiteOrBuilder {
    }

    public interface TypeAliasOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface TypeOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface TypeParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface TypeTableOrBuilder extends MessageLiteOrBuilder {
    }

    public interface ValueParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface VersionRequirementOrBuilder extends MessageLiteOrBuilder {
    }

    public interface VersionRequirementTableOrBuilder extends MessageLiteOrBuilder {
    }

    public enum Modality implements Internal.EnumLite {
        FINAL(0, 0),
        OPEN(1, 1),
        ABSTRACT(2, 2),
        SEALED(3, 3);
        
        private static Internal.EnumLiteMap<Modality> internalValueMap;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<Modality>() {
                public Modality findValueByNumber(int i) {
                    return Modality.valueOf(i);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int i) {
            if (i == 0) {
                return FINAL;
            }
            if (i == 1) {
                return OPEN;
            }
            if (i == 2) {
                return ABSTRACT;
            }
            if (i != 3) {
                return null;
            }
            return SEALED;
        }

        private Modality(int i, int i2) {
            this.value = i2;
        }
    }

    public enum Visibility implements Internal.EnumLite {
        INTERNAL(0, 0),
        PRIVATE(1, 1),
        PROTECTED(2, 2),
        PUBLIC(3, 3),
        PRIVATE_TO_THIS(4, 4),
        LOCAL(5, 5);
        
        private static Internal.EnumLiteMap<Visibility> internalValueMap;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<Visibility>() {
                public Visibility findValueByNumber(int i) {
                    return Visibility.valueOf(i);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int i) {
            if (i == 0) {
                return INTERNAL;
            }
            if (i == 1) {
                return PRIVATE;
            }
            if (i == 2) {
                return PROTECTED;
            }
            if (i == 3) {
                return PUBLIC;
            }
            if (i == 4) {
                return PRIVATE_TO_THIS;
            }
            if (i != 5) {
                return null;
            }
            return LOCAL;
        }

        private Visibility(int i, int i2) {
            this.value = i2;
        }
    }

    public enum MemberKind implements Internal.EnumLite {
        DECLARATION(0, 0),
        FAKE_OVERRIDE(1, 1),
        DELEGATION(2, 2),
        SYNTHESIZED(3, 3);
        
        private static Internal.EnumLiteMap<MemberKind> internalValueMap;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<MemberKind>() {
                public MemberKind findValueByNumber(int i) {
                    return MemberKind.valueOf(i);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int i) {
            if (i == 0) {
                return DECLARATION;
            }
            if (i == 1) {
                return FAKE_OVERRIDE;
            }
            if (i == 2) {
                return DELEGATION;
            }
            if (i != 3) {
                return null;
            }
            return SYNTHESIZED;
        }

        private MemberKind(int i, int i2) {
            this.value = i2;
        }
    }

    public static final class StringTable extends GeneratedMessageLite implements StringTableOrBuilder {
        public static Parser<StringTable> PARSER = new AbstractParser<StringTable>() {
            public StringTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StringTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final StringTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public LazyStringList string_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        private StringTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private StringTable(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        public StringTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        private StringTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            ByteString readBytes = codedInputStream.readBytes();
                            if (!z2) {
                                this.string_ = new LazyStringArrayList();
                                z2 = true;
                            }
                            this.string_.add(readBytes);
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2) {
                        this.string_ = this.string_.getUnmodifiableView();
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2) {
                this.string_ = this.string_.getUnmodifiableView();
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            StringTable stringTable = new StringTable(true);
            defaultInstance = stringTable;
            stringTable.initFields();
        }

        public Parser<StringTable> getParserForType() {
            return PARSER;
        }

        public ProtocolStringList getStringList() {
            return this.string_;
        }

        public String getString(int i) {
            return (String) this.string_.get(i);
        }

        private void initFields() {
            this.string_ = LazyStringArrayList.EMPTY;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.string_.size(); i++) {
                codedOutputStream.writeBytes(1, this.string_.getByteString(i));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.string_.size(); i3++) {
                i2 += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i3));
            }
            int size = i2 + getStringList().size() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(StringTable stringTable) {
            return newBuilder().mergeFrom(stringTable);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StringTable, Builder> implements StringTableOrBuilder {
            private int bitField0_;
            private LazyStringList string_ = LazyStringArrayList.EMPTY;

            private void maybeForceBuilderInitialization() {
            }

            public final boolean isInitialized() {
                return true;
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            public StringTable build() {
                StringTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public StringTable buildPartial() {
                StringTable stringTable = new StringTable((GeneratedMessageLite.Builder) this);
                if ((this.bitField0_ & 1) == 1) {
                    this.string_ = this.string_.getUnmodifiableView();
                    this.bitField0_ &= -2;
                }
                LazyStringList unused = stringTable.string_ = this.string_;
                return stringTable;
            }

            public Builder mergeFrom(StringTable stringTable) {
                if (stringTable == StringTable.getDefaultInstance()) {
                    return this;
                }
                if (!stringTable.string_.isEmpty()) {
                    if (this.string_.isEmpty()) {
                        this.string_ = stringTable.string_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureStringIsMutable();
                        this.string_.addAll(stringTable.string_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(stringTable.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                StringTable stringTable;
                StringTable stringTable2 = null;
                try {
                    StringTable parsePartialFrom = StringTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    stringTable = (StringTable) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    stringTable2 = stringTable;
                }
                if (stringTable2 != null) {
                    mergeFrom(stringTable2);
                }
                throw th;
            }

            private void ensureStringIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.string_ = new LazyStringArrayList(this.string_);
                    this.bitField0_ |= 1;
                }
            }
        }
    }

    public static final class QualifiedNameTable extends GeneratedMessageLite implements QualifiedNameTableOrBuilder {
        public static Parser<QualifiedNameTable> PARSER = new AbstractParser<QualifiedNameTable>() {
            public QualifiedNameTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new QualifiedNameTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final QualifiedNameTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<QualifiedName> qualifiedName_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public interface QualifiedNameOrBuilder extends MessageLiteOrBuilder {
        }

        private QualifiedNameTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QualifiedNameTable(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
        }

        public QualifiedNameTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        private QualifiedNameTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2) {
                                this.qualifiedName_ = new ArrayList();
                                z2 = true;
                            }
                            this.qualifiedName_.add(codedInputStream.readMessage(QualifiedName.PARSER, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2) {
                        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2) {
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(true);
            defaultInstance = qualifiedNameTable;
            qualifiedNameTable.initFields();
        }

        public Parser<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        public static final class QualifiedName extends GeneratedMessageLite implements QualifiedNameOrBuilder {
            public static Parser<QualifiedName> PARSER = new AbstractParser<QualifiedName>() {
                public QualifiedName parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new QualifiedName(codedInputStream, extensionRegistryLite);
                }
            };
            private static final QualifiedName defaultInstance;
            /* access modifiers changed from: private */
            public int bitField0_;
            /* access modifiers changed from: private */
            public Kind kind_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            /* access modifiers changed from: private */
            public int parentQualifiedName_;
            /* access modifiers changed from: private */
            public int shortName_;
            /* access modifiers changed from: private */
            public final ByteString unknownFields;

            private QualifiedName(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private QualifiedName(boolean z) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            public QualifiedName getDefaultInstanceForType() {
                return defaultInstance;
            }

            private QualifiedName(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.parentQualifiedName_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.bitField0_ |= 2;
                                this.shortName_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                int readEnum = codedInputStream.readEnum();
                                Kind valueOf = Kind.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.kind_ = valueOf;
                                }
                            } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = newOutput.toByteString();
                            throw th2;
                        }
                        this.unknownFields = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = newOutput.toByteString();
                    throw th3;
                }
                this.unknownFields = newOutput.toByteString();
                makeExtensionsImmutable();
            }

            static {
                QualifiedName qualifiedName = new QualifiedName(true);
                defaultInstance = qualifiedName;
                qualifiedName.initFields();
            }

            public Parser<QualifiedName> getParserForType() {
                return PARSER;
            }

            public enum Kind implements Internal.EnumLite {
                CLASS(0, 0),
                PACKAGE(1, 1),
                LOCAL(2, 2);
                
                private static Internal.EnumLiteMap<Kind> internalValueMap;
                private final int value;

                static {
                    internalValueMap = new Internal.EnumLiteMap<Kind>() {
                        public Kind findValueByNumber(int i) {
                            return Kind.valueOf(i);
                        }
                    };
                }

                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int i) {
                    if (i == 0) {
                        return CLASS;
                    }
                    if (i == 1) {
                        return PACKAGE;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return LOCAL;
                }

                private Kind(int i, int i2) {
                    this.value = i2;
                }
            }

            public boolean hasParentQualifiedName() {
                return (this.bitField0_ & 1) == 1;
            }

            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            public boolean hasShortName() {
                return (this.bitField0_ & 2) == 2;
            }

            public int getShortName() {
                return this.shortName_;
            }

            public boolean hasKind() {
                return (this.bitField0_ & 4) == 4;
            }

            public Kind getKind() {
                return this.kind_;
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
            }

            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == 1) {
                    return true;
                }
                if (b == 0) {
                    return false;
                }
                if (!hasShortName()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeEnum(3, this.kind_.getNumber());
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
                }
                int size = computeInt32Size + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(QualifiedName qualifiedName) {
                return newBuilder().mergeFrom(qualifiedName);
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<QualifiedName, Builder> implements QualifiedNameOrBuilder {
                private int bitField0_;
                private Kind kind_ = Kind.PACKAGE;
                private int parentQualifiedName_ = -1;
                private int shortName_;

                private void maybeForceBuilderInitialization() {
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                /* access modifiers changed from: private */
                public static Builder create() {
                    return new Builder();
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                public QualifiedName build() {
                    QualifiedName buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException(buildPartial);
                }

                public QualifiedName buildPartial() {
                    QualifiedName qualifiedName = new QualifiedName((GeneratedMessageLite.Builder) this);
                    int i = this.bitField0_;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    int unused = qualifiedName.parentQualifiedName_ = this.parentQualifiedName_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    int unused2 = qualifiedName.shortName_ = this.shortName_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    Kind unused3 = qualifiedName.kind_ = this.kind_;
                    int unused4 = qualifiedName.bitField0_ = i2;
                    return qualifiedName;
                }

                public Builder mergeFrom(QualifiedName qualifiedName) {
                    if (qualifiedName == QualifiedName.getDefaultInstance()) {
                        return this;
                    }
                    if (qualifiedName.hasParentQualifiedName()) {
                        setParentQualifiedName(qualifiedName.getParentQualifiedName());
                    }
                    if (qualifiedName.hasShortName()) {
                        setShortName(qualifiedName.getShortName());
                    }
                    if (qualifiedName.hasKind()) {
                        setKind(qualifiedName.getKind());
                    }
                    setUnknownFields(getUnknownFields().concat(qualifiedName.unknownFields));
                    return this;
                }

                public final boolean isInitialized() {
                    return hasShortName();
                }

                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    QualifiedName qualifiedName;
                    QualifiedName qualifiedName2 = null;
                    try {
                        QualifiedName parsePartialFrom = QualifiedName.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        qualifiedName = (QualifiedName) e.getUnfinishedMessage();
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        qualifiedName2 = qualifiedName;
                    }
                    if (qualifiedName2 != null) {
                        mergeFrom(qualifiedName2);
                    }
                    throw th;
                }

                public Builder setParentQualifiedName(int i) {
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = i;
                    return this;
                }

                public boolean hasShortName() {
                    return (this.bitField0_ & 2) == 2;
                }

                public Builder setShortName(int i) {
                    this.bitField0_ |= 2;
                    this.shortName_ = i;
                    return this;
                }

                public Builder setKind(Kind kind) {
                    kind.getClass();
                    this.bitField0_ |= 4;
                    this.kind_ = kind;
                    return this;
                }
            }
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        public QualifiedName getQualifiedName(int i) {
            return this.qualifiedName_.get(i);
        }

        private void initFields() {
            this.qualifiedName_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < getQualifiedNameCount(); i++) {
                if (!getQualifiedName(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.qualifiedName_.size(); i++) {
                codedOutputStream.writeMessage(1, this.qualifiedName_.get(i));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.qualifiedName_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(i3));
            }
            int size = i2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(QualifiedNameTable qualifiedNameTable) {
            return newBuilder().mergeFrom(qualifiedNameTable);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<QualifiedNameTable, Builder> implements QualifiedNameTableOrBuilder {
            private int bitField0_;
            private List<QualifiedName> qualifiedName_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            public QualifiedNameTable build() {
                QualifiedNameTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public QualifiedNameTable buildPartial() {
                QualifiedNameTable qualifiedNameTable = new QualifiedNameTable((GeneratedMessageLite.Builder) this);
                if ((this.bitField0_ & 1) == 1) {
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                    this.bitField0_ &= -2;
                }
                List unused = qualifiedNameTable.qualifiedName_ = this.qualifiedName_;
                return qualifiedNameTable;
            }

            public Builder mergeFrom(QualifiedNameTable qualifiedNameTable) {
                if (qualifiedNameTable == QualifiedNameTable.getDefaultInstance()) {
                    return this;
                }
                if (!qualifiedNameTable.qualifiedName_.isEmpty()) {
                    if (this.qualifiedName_.isEmpty()) {
                        this.qualifiedName_ = qualifiedNameTable.qualifiedName_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureQualifiedNameIsMutable();
                        this.qualifiedName_.addAll(qualifiedNameTable.qualifiedName_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(qualifiedNameTable.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getQualifiedNameCount(); i++) {
                    if (!getQualifiedName(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                QualifiedNameTable qualifiedNameTable;
                QualifiedNameTable qualifiedNameTable2 = null;
                try {
                    QualifiedNameTable parsePartialFrom = QualifiedNameTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    qualifiedNameTable = (QualifiedNameTable) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    qualifiedNameTable2 = qualifiedNameTable;
                }
                if (qualifiedNameTable2 != null) {
                    mergeFrom(qualifiedNameTable2);
                }
                throw th;
            }

            private void ensureQualifiedNameIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.qualifiedName_ = new ArrayList(this.qualifiedName_);
                    this.bitField0_ |= 1;
                }
            }

            public int getQualifiedNameCount() {
                return this.qualifiedName_.size();
            }

            public QualifiedName getQualifiedName(int i) {
                return this.qualifiedName_.get(i);
            }
        }
    }

    public static final class Annotation extends GeneratedMessageLite implements AnnotationOrBuilder {
        public static Parser<Annotation> PARSER = new AbstractParser<Annotation>() {
            public Annotation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Annotation(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Annotation defaultInstance;
        /* access modifiers changed from: private */
        public List<Argument> argument_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        private Annotation(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Annotation(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        public Annotation getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Annotation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.id_ = codedInputStream.readInt32();
                        } else if (readTag == 18) {
                            if (!(z2 & true)) {
                                this.argument_ = new ArrayList();
                                z2 = true;
                            }
                            this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            Annotation annotation = new Annotation(true);
            defaultInstance = annotation;
            annotation.initFields();
        }

        public Parser<Annotation> getParserForType() {
            return PARSER;
        }

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER = new AbstractParser<Argument>() {
                public Argument parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Argument(codedInputStream, extensionRegistryLite);
                }
            };
            private static final Argument defaultInstance;
            /* access modifiers changed from: private */
            public int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            /* access modifiers changed from: private */
            public int nameId_;
            /* access modifiers changed from: private */
            public final ByteString unknownFields;
            /* access modifiers changed from: private */
            public Value value_;

            public interface ValueOrBuilder extends MessageLiteOrBuilder {
            }

            private Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private Argument(boolean z) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            private Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.nameId_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                Value.Builder builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                Value value = (Value) codedInputStream.readMessage(Value.PARSER, extensionRegistryLite);
                                this.value_ = value;
                                if (builder != null) {
                                    builder.mergeFrom(value);
                                    this.value_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = newOutput.toByteString();
                            throw th2;
                        }
                        this.unknownFields = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = newOutput.toByteString();
                    throw th3;
                }
                this.unknownFields = newOutput.toByteString();
                makeExtensionsImmutable();
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public static final class Value extends GeneratedMessageLite implements ValueOrBuilder {
                public static Parser<Value> PARSER = new AbstractParser<Value>() {
                    public Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return new Value(codedInputStream, extensionRegistryLite);
                    }
                };
                private static final Value defaultInstance;
                /* access modifiers changed from: private */
                public Annotation annotation_;
                /* access modifiers changed from: private */
                public int arrayDimensionCount_;
                /* access modifiers changed from: private */
                public List<Value> arrayElement_;
                /* access modifiers changed from: private */
                public int bitField0_;
                /* access modifiers changed from: private */
                public int classId_;
                /* access modifiers changed from: private */
                public double doubleValue_;
                /* access modifiers changed from: private */
                public int enumValueId_;
                /* access modifiers changed from: private */
                public int flags_;
                /* access modifiers changed from: private */
                public float floatValue_;
                /* access modifiers changed from: private */
                public long intValue_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                /* access modifiers changed from: private */
                public int stringValue_;
                /* access modifiers changed from: private */
                public Type type_;
                /* access modifiers changed from: private */
                public final ByteString unknownFields;

                private Value(GeneratedMessageLite.Builder builder) {
                    super(builder);
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = builder.getUnknownFields();
                }

                private Value(boolean z) {
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = ByteString.EMPTY;
                }

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                public Value getDefaultInstanceForType() {
                    return defaultInstance;
                }

                private Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    initFields();
                    ByteString.Output newOutput = ByteString.newOutput();
                    CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    int readEnum = codedInputStream.readEnum();
                                    Type valueOf = Type.valueOf(readEnum);
                                    if (valueOf != null) {
                                        this.bitField0_ |= 1;
                                        this.type_ = valueOf;
                                        break;
                                    } else {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                        break;
                                    }
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.intValue_ = codedInputStream.readSInt64();
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                                    this.bitField0_ |= 4;
                                    this.floatValue_ = codedInputStream.readFloat();
                                    break;
                                case 33:
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = codedInputStream.readDouble();
                                    break;
                                case 40:
                                    this.bitField0_ |= 16;
                                    this.stringValue_ = codedInputStream.readInt32();
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                                    this.bitField0_ |= 32;
                                    this.classId_ = codedInputStream.readInt32();
                                    break;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.enumValueId_ = codedInputStream.readInt32();
                                    break;
                                case 66:
                                    Builder builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                    Annotation annotation = (Annotation) codedInputStream.readMessage(Annotation.PARSER, extensionRegistryLite);
                                    this.annotation_ = annotation;
                                    if (builder != null) {
                                        builder.mergeFrom(annotation);
                                        this.annotation_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 128;
                                    break;
                                case 74:
                                    if (!(z2 & true)) {
                                        this.arrayElement_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.arrayElement_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                                    break;
                                case 80:
                                    this.bitField0_ |= 512;
                                    this.flags_ = codedInputStream.readInt32();
                                    break;
                                case 88:
                                    this.bitField0_ |= 256;
                                    this.arrayDimensionCount_ = codedInputStream.readInt32();
                                    break;
                                default:
                                    if (parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        } catch (Throwable th) {
                            if (z2 & true) {
                                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                            }
                            try {
                                newInstance.flush();
                            } catch (IOException unused) {
                            } catch (Throwable th2) {
                                this.unknownFields = newOutput.toByteString();
                                throw th2;
                            }
                            this.unknownFields = newOutput.toByteString();
                            makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 & true) {
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused2) {
                    } catch (Throwable th3) {
                        this.unknownFields = newOutput.toByteString();
                        throw th3;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                }

                static {
                    Value value = new Value(true);
                    defaultInstance = value;
                    value.initFields();
                }

                public Parser<Value> getParserForType() {
                    return PARSER;
                }

                public enum Type implements Internal.EnumLite {
                    BYTE(0, 0),
                    CHAR(1, 1),
                    SHORT(2, 2),
                    INT(3, 3),
                    LONG(4, 4),
                    FLOAT(5, 5),
                    DOUBLE(6, 6),
                    BOOLEAN(7, 7),
                    STRING(8, 8),
                    CLASS(9, 9),
                    ENUM(10, 10),
                    ANNOTATION(11, 11),
                    ARRAY(12, 12);
                    
                    private static Internal.EnumLiteMap<Type> internalValueMap;
                    private final int value;

                    static {
                        internalValueMap = new Internal.EnumLiteMap<Type>() {
                            public Type findValueByNumber(int i) {
                                return Type.valueOf(i);
                            }
                        };
                    }

                    public final int getNumber() {
                        return this.value;
                    }

                    public static Type valueOf(int i) {
                        switch (i) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }

                    private Type(int i, int i2) {
                        this.value = i2;
                    }
                }

                public boolean hasType() {
                    return (this.bitField0_ & 1) == 1;
                }

                public Type getType() {
                    return this.type_;
                }

                public boolean hasIntValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                public long getIntValue() {
                    return this.intValue_;
                }

                public boolean hasFloatValue() {
                    return (this.bitField0_ & 4) == 4;
                }

                public float getFloatValue() {
                    return this.floatValue_;
                }

                public boolean hasDoubleValue() {
                    return (this.bitField0_ & 8) == 8;
                }

                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                public boolean hasStringValue() {
                    return (this.bitField0_ & 16) == 16;
                }

                public int getStringValue() {
                    return this.stringValue_;
                }

                public boolean hasClassId() {
                    return (this.bitField0_ & 32) == 32;
                }

                public int getClassId() {
                    return this.classId_;
                }

                public boolean hasEnumValueId() {
                    return (this.bitField0_ & 64) == 64;
                }

                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                public boolean hasAnnotation() {
                    return (this.bitField0_ & 128) == 128;
                }

                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                public List<Value> getArrayElementList() {
                    return this.arrayElement_;
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                public Value getArrayElement(int i) {
                    return this.arrayElement_.get(i);
                }

                public boolean hasArrayDimensionCount() {
                    return (this.bitField0_ & 256) == 256;
                }

                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                public boolean hasFlags() {
                    return (this.bitField0_ & 512) == 512;
                }

                public int getFlags() {
                    return this.flags_;
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
                }

                public final boolean isInitialized() {
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return true;
                    }
                    if (b == 0) {
                        return false;
                    }
                    if (!hasAnnotation() || getAnnotation().isInitialized()) {
                        for (int i = 0; i < getArrayElementCount(); i++) {
                            if (!getArrayElement(i).isInitialized()) {
                                this.memoizedIsInitialized = 0;
                                return false;
                            }
                        }
                        this.memoizedIsInitialized = 1;
                        return true;
                    }
                    this.memoizedIsInitialized = 0;
                    return false;
                }

                public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                    getSerializedSize();
                    if ((this.bitField0_ & 1) == 1) {
                        codedOutputStream.writeEnum(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        codedOutputStream.writeSInt64(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        codedOutputStream.writeFloat(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        codedOutputStream.writeDouble(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        codedOutputStream.writeInt32(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        codedOutputStream.writeInt32(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        codedOutputStream.writeInt32(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        codedOutputStream.writeMessage(8, this.annotation_);
                    }
                    for (int i = 0; i < this.arrayElement_.size(); i++) {
                        codedOutputStream.writeMessage(9, this.arrayElement_.get(i));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        codedOutputStream.writeInt32(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        codedOutputStream.writeInt32(11, this.arrayDimensionCount_);
                    }
                    codedOutputStream.writeRawBytes(this.unknownFields);
                }

                public int getSerializedSize() {
                    int i = this.memoizedSerializedSize;
                    if (i != -1) {
                        return i;
                    }
                    int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) : 0;
                    if ((this.bitField0_ & 2) == 2) {
                        computeEnumSize += CodedOutputStream.computeSInt64Size(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        computeEnumSize += CodedOutputStream.computeFloatSize(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        computeEnumSize += CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        computeEnumSize += CodedOutputStream.computeMessageSize(8, this.annotation_);
                    }
                    for (int i2 = 0; i2 < this.arrayElement_.size(); i2++) {
                        computeEnumSize += CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(i2));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                    }
                    int size = computeEnumSize + this.unknownFields.size();
                    this.memoizedSerializedSize = size;
                    return size;
                }

                public static Builder newBuilder() {
                    return Builder.create();
                }

                public Builder newBuilderForType() {
                    return newBuilder();
                }

                public static Builder newBuilder(Value value) {
                    return newBuilder().mergeFrom(value);
                }

                public Builder toBuilder() {
                    return newBuilder(this);
                }

                public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
                    private Annotation annotation_ = Annotation.getDefaultInstance();
                    private int arrayDimensionCount_;
                    private List<Value> arrayElement_ = Collections.emptyList();
                    private int bitField0_;
                    private int classId_;
                    private double doubleValue_;
                    private int enumValueId_;
                    private int flags_;
                    private float floatValue_;
                    private long intValue_;
                    private int stringValue_;
                    private Type type_ = Type.BYTE;

                    private void maybeForceBuilderInitialization() {
                    }

                    private Builder() {
                        maybeForceBuilderInitialization();
                    }

                    /* access modifiers changed from: private */
                    public static Builder create() {
                        return new Builder();
                    }

                    public Builder clone() {
                        return create().mergeFrom(buildPartial());
                    }

                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    public Value build() {
                        Value buildPartial = buildPartial();
                        if (buildPartial.isInitialized()) {
                            return buildPartial;
                        }
                        throw newUninitializedMessageException(buildPartial);
                    }

                    public Value buildPartial() {
                        Value value = new Value((GeneratedMessageLite.Builder) this);
                        int i = this.bitField0_;
                        int i2 = 1;
                        if ((i & 1) != 1) {
                            i2 = 0;
                        }
                        Type unused = value.type_ = this.type_;
                        if ((i & 2) == 2) {
                            i2 |= 2;
                        }
                        long unused2 = value.intValue_ = this.intValue_;
                        if ((i & 4) == 4) {
                            i2 |= 4;
                        }
                        float unused3 = value.floatValue_ = this.floatValue_;
                        if ((i & 8) == 8) {
                            i2 |= 8;
                        }
                        double unused4 = value.doubleValue_ = this.doubleValue_;
                        if ((i & 16) == 16) {
                            i2 |= 16;
                        }
                        int unused5 = value.stringValue_ = this.stringValue_;
                        if ((i & 32) == 32) {
                            i2 |= 32;
                        }
                        int unused6 = value.classId_ = this.classId_;
                        if ((i & 64) == 64) {
                            i2 |= 64;
                        }
                        int unused7 = value.enumValueId_ = this.enumValueId_;
                        if ((i & 128) == 128) {
                            i2 |= 128;
                        }
                        Annotation unused8 = value.annotation_ = this.annotation_;
                        if ((this.bitField0_ & 256) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                            this.bitField0_ &= -257;
                        }
                        List unused9 = value.arrayElement_ = this.arrayElement_;
                        if ((i & 512) == 512) {
                            i2 |= 256;
                        }
                        int unused10 = value.arrayDimensionCount_ = this.arrayDimensionCount_;
                        if ((i & 1024) == 1024) {
                            i2 |= 512;
                        }
                        int unused11 = value.flags_ = this.flags_;
                        int unused12 = value.bitField0_ = i2;
                        return value;
                    }

                    public Builder mergeFrom(Value value) {
                        if (value == Value.getDefaultInstance()) {
                            return this;
                        }
                        if (value.hasType()) {
                            setType(value.getType());
                        }
                        if (value.hasIntValue()) {
                            setIntValue(value.getIntValue());
                        }
                        if (value.hasFloatValue()) {
                            setFloatValue(value.getFloatValue());
                        }
                        if (value.hasDoubleValue()) {
                            setDoubleValue(value.getDoubleValue());
                        }
                        if (value.hasStringValue()) {
                            setStringValue(value.getStringValue());
                        }
                        if (value.hasClassId()) {
                            setClassId(value.getClassId());
                        }
                        if (value.hasEnumValueId()) {
                            setEnumValueId(value.getEnumValueId());
                        }
                        if (value.hasAnnotation()) {
                            mergeAnnotation(value.getAnnotation());
                        }
                        if (!value.arrayElement_.isEmpty()) {
                            if (this.arrayElement_.isEmpty()) {
                                this.arrayElement_ = value.arrayElement_;
                                this.bitField0_ &= -257;
                            } else {
                                ensureArrayElementIsMutable();
                                this.arrayElement_.addAll(value.arrayElement_);
                            }
                        }
                        if (value.hasArrayDimensionCount()) {
                            setArrayDimensionCount(value.getArrayDimensionCount());
                        }
                        if (value.hasFlags()) {
                            setFlags(value.getFlags());
                        }
                        setUnknownFields(getUnknownFields().concat(value.unknownFields));
                        return this;
                    }

                    public final boolean isInitialized() {
                        if (hasAnnotation() && !getAnnotation().isInitialized()) {
                            return false;
                        }
                        for (int i = 0; i < getArrayElementCount(); i++) {
                            if (!getArrayElement(i).isInitialized()) {
                                return false;
                            }
                        }
                        return true;
                    }

                    public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        Value value;
                        Value value2 = null;
                        try {
                            Value parsePartialFrom = Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            value = (Value) e.getUnfinishedMessage();
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            value2 = value;
                        }
                        if (value2 != null) {
                            mergeFrom(value2);
                        }
                        throw th;
                    }

                    public Builder setType(Type type) {
                        type.getClass();
                        this.bitField0_ |= 1;
                        this.type_ = type;
                        return this;
                    }

                    public Builder setIntValue(long j) {
                        this.bitField0_ |= 2;
                        this.intValue_ = j;
                        return this;
                    }

                    public Builder setFloatValue(float f) {
                        this.bitField0_ |= 4;
                        this.floatValue_ = f;
                        return this;
                    }

                    public Builder setDoubleValue(double d) {
                        this.bitField0_ |= 8;
                        this.doubleValue_ = d;
                        return this;
                    }

                    public Builder setStringValue(int i) {
                        this.bitField0_ |= 16;
                        this.stringValue_ = i;
                        return this;
                    }

                    public Builder setClassId(int i) {
                        this.bitField0_ |= 32;
                        this.classId_ = i;
                        return this;
                    }

                    public Builder setEnumValueId(int i) {
                        this.bitField0_ |= 64;
                        this.enumValueId_ = i;
                        return this;
                    }

                    public boolean hasAnnotation() {
                        return (this.bitField0_ & 128) == 128;
                    }

                    public Annotation getAnnotation() {
                        return this.annotation_;
                    }

                    public Builder mergeAnnotation(Annotation annotation) {
                        if ((this.bitField0_ & 128) != 128 || this.annotation_ == Annotation.getDefaultInstance()) {
                            this.annotation_ = annotation;
                        } else {
                            this.annotation_ = Annotation.newBuilder(this.annotation_).mergeFrom(annotation).buildPartial();
                        }
                        this.bitField0_ |= 128;
                        return this;
                    }

                    private void ensureArrayElementIsMutable() {
                        if ((this.bitField0_ & 256) != 256) {
                            this.arrayElement_ = new ArrayList(this.arrayElement_);
                            this.bitField0_ |= 256;
                        }
                    }

                    public int getArrayElementCount() {
                        return this.arrayElement_.size();
                    }

                    public Value getArrayElement(int i) {
                        return this.arrayElement_.get(i);
                    }

                    public Builder setArrayDimensionCount(int i) {
                        this.bitField0_ |= 512;
                        this.arrayDimensionCount_ = i;
                        return this;
                    }

                    public Builder setFlags(int i) {
                        this.bitField0_ |= 1024;
                        this.flags_ = i;
                        return this;
                    }
                }
            }

            public boolean hasNameId() {
                return (this.bitField0_ & 1) == 1;
            }

            public int getNameId() {
                return this.nameId_;
            }

            public boolean hasValue() {
                return (this.bitField0_ & 2) == 2;
            }

            public Value getValue() {
                return this.value_;
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
            }

            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == 1) {
                    return true;
                }
                if (b == 0) {
                    return false;
                }
                if (!hasNameId()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else if (!hasValue()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else if (!getValue().isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = 1;
                    return true;
                }
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.value_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.nameId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeMessageSize(2, this.value_);
                }
                int size = computeInt32Size + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(Argument argument) {
                return newBuilder().mergeFrom(argument);
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private int nameId_;
                private Value value_ = Value.getDefaultInstance();

                private void maybeForceBuilderInitialization() {
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                /* access modifiers changed from: private */
                public static Builder create() {
                    return new Builder();
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                public Argument build() {
                    Argument buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException(buildPartial);
                }

                public Argument buildPartial() {
                    Argument argument = new Argument((GeneratedMessageLite.Builder) this);
                    int i = this.bitField0_;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    int unused = argument.nameId_ = this.nameId_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    Value unused2 = argument.value_ = this.value_;
                    int unused3 = argument.bitField0_ = i2;
                    return argument;
                }

                public Builder mergeFrom(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasNameId()) {
                        setNameId(argument.getNameId());
                    }
                    if (argument.hasValue()) {
                        mergeValue(argument.getValue());
                    }
                    setUnknownFields(getUnknownFields().concat(argument.unknownFields));
                    return this;
                }

                public final boolean isInitialized() {
                    if (hasNameId() && hasValue() && getValue().isInitialized()) {
                        return true;
                    }
                    return false;
                }

                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Argument argument;
                    Argument argument2 = null;
                    try {
                        Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        argument = (Argument) e.getUnfinishedMessage();
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        argument2 = argument;
                    }
                    if (argument2 != null) {
                        mergeFrom(argument2);
                    }
                    throw th;
                }

                public boolean hasNameId() {
                    return (this.bitField0_ & 1) == 1;
                }

                public Builder setNameId(int i) {
                    this.bitField0_ |= 1;
                    this.nameId_ = i;
                    return this;
                }

                public boolean hasValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                public Value getValue() {
                    return this.value_;
                }

                public Builder mergeValue(Value value) {
                    if ((this.bitField0_ & 2) != 2 || this.value_ == Value.getDefaultInstance()) {
                        this.value_ = value;
                    } else {
                        this.value_ = Value.newBuilder(this.value_).mergeFrom(value).buildPartial();
                    }
                    this.bitField0_ |= 2;
                    return this;
                }
            }
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getId() {
            return this.id_;
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public Argument getArgument(int i) {
            return this.argument_.get(i);
        }

        private void initFields() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getArgumentCount(); i++) {
                if (!getArgument(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.id_);
            }
            for (int i = 0; i < this.argument_.size(); i++) {
                codedOutputStream.writeMessage(2, this.argument_.get(i));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) : 0;
            for (int i2 = 0; i2 < this.argument_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
            }
            int size = computeInt32Size + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Annotation annotation) {
            return newBuilder().mergeFrom(annotation);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
            private List<Argument> argument_ = Collections.emptyList();
            private int bitField0_;
            private int id_;

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            public Annotation build() {
                Annotation buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public Annotation buildPartial() {
                Annotation annotation = new Annotation((GeneratedMessageLite.Builder) this);
                int i = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                int unused = annotation.id_ = this.id_;
                if ((this.bitField0_ & 2) == 2) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= -3;
                }
                List unused2 = annotation.argument_ = this.argument_;
                int unused3 = annotation.bitField0_ = i;
                return annotation;
            }

            public Builder mergeFrom(Annotation annotation) {
                if (annotation == Annotation.getDefaultInstance()) {
                    return this;
                }
                if (annotation.hasId()) {
                    setId(annotation.getId());
                }
                if (!annotation.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = annotation.argument_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureArgumentIsMutable();
                        this.argument_.addAll(annotation.argument_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(annotation.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                for (int i = 0; i < getArgumentCount(); i++) {
                    if (!getArgument(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Annotation annotation;
                Annotation annotation2 = null;
                try {
                    Annotation parsePartialFrom = Annotation.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    annotation = (Annotation) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    annotation2 = annotation;
                }
                if (annotation2 != null) {
                    mergeFrom(annotation2);
                }
                throw th;
            }

            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            public Builder setId(int i) {
                this.bitField0_ |= 1;
                this.id_ = i;
                return this;
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.argument_ = new ArrayList(this.argument_);
                    this.bitField0_ |= 2;
                }
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public Argument getArgument(int i) {
                return this.argument_.get(i);
            }
        }
    }

    public static final class Type extends GeneratedMessageLite.ExtendableMessage<Type> implements TypeOrBuilder {
        public static Parser<Type> PARSER = new AbstractParser<Type>() {
            public Type parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Type(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Type defaultInstance;
        /* access modifiers changed from: private */
        public int abbreviatedTypeId_;
        /* access modifiers changed from: private */
        public Type abbreviatedType_;
        /* access modifiers changed from: private */
        public List<Argument> argument_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int className_;
        /* access modifiers changed from: private */
        public int flags_;
        /* access modifiers changed from: private */
        public int flexibleTypeCapabilitiesId_;
        /* access modifiers changed from: private */
        public int flexibleUpperBoundId_;
        /* access modifiers changed from: private */
        public Type flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public boolean nullable_;
        /* access modifiers changed from: private */
        public int outerTypeId_;
        /* access modifiers changed from: private */
        public Type outerType_;
        /* access modifiers changed from: private */
        public int typeAliasName_;
        /* access modifiers changed from: private */
        public int typeParameterName_;
        /* access modifiers changed from: private */
        public int typeParameter_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        private Type(GeneratedMessageLite.ExtendableBuilder<Type, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Type(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        public Type getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Type(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    Builder builder = null;
                    switch (readTag) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            this.bitField0_ |= 4096;
                            this.flags_ = codedInputStream.readInt32();
                            break;
                        case 18:
                            if (!z2) {
                                this.argument_ = new ArrayList();
                                z2 = true;
                            }
                            this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                            break;
                        case 24:
                            this.bitField0_ |= 1;
                            this.nullable_ = codedInputStream.readBool();
                            break;
                        case 32:
                            this.bitField0_ |= 2;
                            this.flexibleTypeCapabilitiesId_ = codedInputStream.readInt32();
                            break;
                        case 42:
                            builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : builder;
                            Type type = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                            this.flexibleUpperBound_ = type;
                            if (builder != null) {
                                builder.mergeFrom(type);
                                this.flexibleUpperBound_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            this.bitField0_ |= 16;
                            this.className_ = codedInputStream.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 32;
                            this.typeParameter_ = codedInputStream.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 8;
                            this.flexibleUpperBoundId_ = codedInputStream.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 64;
                            this.typeParameterName_ = codedInputStream.readInt32();
                            break;
                        case 82:
                            builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : builder;
                            Type type2 = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                            this.outerType_ = type2;
                            if (builder != null) {
                                builder.mergeFrom(type2);
                                this.outerType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 256;
                            break;
                        case 88:
                            this.bitField0_ |= 512;
                            this.outerTypeId_ = codedInputStream.readInt32();
                            break;
                        case TarConstants.SPARSELEN_GNU /*96*/:
                            this.bitField0_ |= 128;
                            this.typeAliasName_ = codedInputStream.readInt32();
                            break;
                        case 106:
                            builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : builder;
                            Type type3 = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                            this.abbreviatedType_ = type3;
                            if (builder != null) {
                                builder.mergeFrom(type3);
                                this.abbreviatedType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 1024;
                            break;
                        case 112:
                            this.bitField0_ |= 2048;
                            this.abbreviatedTypeId_ = codedInputStream.readInt32();
                            break;
                        default:
                            if (parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                break;
                            }
                            z = true;
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            Type type = new Type(true);
            defaultInstance = type;
            type.initFields();
        }

        public Parser<Type> getParserForType() {
            return PARSER;
        }

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER = new AbstractParser<Argument>() {
                public Argument parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Argument(codedInputStream, extensionRegistryLite);
                }
            };
            private static final Argument defaultInstance;
            /* access modifiers changed from: private */
            public int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            /* access modifiers changed from: private */
            public Projection projection_;
            /* access modifiers changed from: private */
            public int typeId_;
            /* access modifiers changed from: private */
            public Type type_;
            /* access modifiers changed from: private */
            public final ByteString unknownFields;

            private Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private Argument(boolean z) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            private Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                int readEnum = codedInputStream.readEnum();
                                Projection valueOf = Projection.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.bitField0_ |= 1;
                                    this.projection_ = valueOf;
                                }
                            } else if (readTag == 18) {
                                Builder builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                this.type_ = type;
                                if (builder != null) {
                                    builder.mergeFrom(type);
                                    this.type_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (readTag == 24) {
                                this.bitField0_ |= 4;
                                this.typeId_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = newOutput.toByteString();
                            throw th2;
                        }
                        this.unknownFields = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = newOutput.toByteString();
                    throw th3;
                }
                this.unknownFields = newOutput.toByteString();
                makeExtensionsImmutable();
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public enum Projection implements Internal.EnumLite {
                IN(0, 0),
                OUT(1, 1),
                INV(2, 2),
                STAR(3, 3);
                
                private static Internal.EnumLiteMap<Projection> internalValueMap;
                private final int value;

                static {
                    internalValueMap = new Internal.EnumLiteMap<Projection>() {
                        public Projection findValueByNumber(int i) {
                            return Projection.valueOf(i);
                        }
                    };
                }

                public final int getNumber() {
                    return this.value;
                }

                public static Projection valueOf(int i) {
                    if (i == 0) {
                        return IN;
                    }
                    if (i == 1) {
                        return OUT;
                    }
                    if (i == 2) {
                        return INV;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return STAR;
                }

                private Projection(int i, int i2) {
                    this.value = i2;
                }
            }

            public boolean hasProjection() {
                return (this.bitField0_ & 1) == 1;
            }

            public Projection getProjection() {
                return this.projection_;
            }

            public boolean hasType() {
                return (this.bitField0_ & 2) == 2;
            }

            public Type getType() {
                return this.type_;
            }

            public boolean hasTypeId() {
                return (this.bitField0_ & 4) == 4;
            }

            public int getTypeId() {
                return this.typeId_;
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
            }

            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == 1) {
                    return true;
                }
                if (b == 0) {
                    return false;
                }
                if (!hasType() || getType().isInitialized()) {
                    this.memoizedIsInitialized = 1;
                    return true;
                }
                this.memoizedIsInitialized = 0;
                return false;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeInt32(3, this.typeId_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.projection_.getNumber()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(3, this.typeId_);
                }
                int size = computeEnumSize + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(Argument argument) {
                return newBuilder().mergeFrom(argument);
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private Projection projection_ = Projection.INV;
                private int typeId_;
                private Type type_ = Type.getDefaultInstance();

                private void maybeForceBuilderInitialization() {
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                /* access modifiers changed from: private */
                public static Builder create() {
                    return new Builder();
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                public Argument build() {
                    Argument buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException(buildPartial);
                }

                public Argument buildPartial() {
                    Argument argument = new Argument((GeneratedMessageLite.Builder) this);
                    int i = this.bitField0_;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    Projection unused = argument.projection_ = this.projection_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    Type unused2 = argument.type_ = this.type_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    int unused3 = argument.typeId_ = this.typeId_;
                    int unused4 = argument.bitField0_ = i2;
                    return argument;
                }

                public Builder mergeFrom(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasProjection()) {
                        setProjection(argument.getProjection());
                    }
                    if (argument.hasType()) {
                        mergeType(argument.getType());
                    }
                    if (argument.hasTypeId()) {
                        setTypeId(argument.getTypeId());
                    }
                    setUnknownFields(getUnknownFields().concat(argument.unknownFields));
                    return this;
                }

                public final boolean isInitialized() {
                    return !hasType() || getType().isInitialized();
                }

                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Argument argument;
                    Argument argument2 = null;
                    try {
                        Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        argument = (Argument) e.getUnfinishedMessage();
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        argument2 = argument;
                    }
                    if (argument2 != null) {
                        mergeFrom(argument2);
                    }
                    throw th;
                }

                public Builder setProjection(Projection projection) {
                    projection.getClass();
                    this.bitField0_ |= 1;
                    this.projection_ = projection;
                    return this;
                }

                public boolean hasType() {
                    return (this.bitField0_ & 2) == 2;
                }

                public Type getType() {
                    return this.type_;
                }

                public Builder mergeType(Type type) {
                    if ((this.bitField0_ & 2) != 2 || this.type_ == Type.getDefaultInstance()) {
                        this.type_ = type;
                    } else {
                        this.type_ = Type.newBuilder(this.type_).mergeFrom(type).buildPartial();
                    }
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder setTypeId(int i) {
                    this.bitField0_ |= 4;
                    this.typeId_ = i;
                    return this;
                }
            }
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public Argument getArgument(int i) {
            return this.argument_.get(i);
        }

        public boolean hasNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getNullable() {
            return this.nullable_;
        }

        public boolean hasFlexibleTypeCapabilitiesId() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public boolean hasFlexibleUpperBound() {
            return (this.bitField0_ & 4) == 4;
        }

        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public boolean hasFlexibleUpperBoundId() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        public boolean hasClassName() {
            return (this.bitField0_ & 16) == 16;
        }

        public int getClassName() {
            return this.className_;
        }

        public boolean hasTypeParameter() {
            return (this.bitField0_ & 32) == 32;
        }

        public int getTypeParameter() {
            return this.typeParameter_;
        }

        public boolean hasTypeParameterName() {
            return (this.bitField0_ & 64) == 64;
        }

        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        public boolean hasTypeAliasName() {
            return (this.bitField0_ & 128) == 128;
        }

        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        public boolean hasOuterType() {
            return (this.bitField0_ & 256) == 256;
        }

        public Type getOuterType() {
            return this.outerType_;
        }

        public boolean hasOuterTypeId() {
            return (this.bitField0_ & 512) == 512;
        }

        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        public boolean hasAbbreviatedType() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public boolean hasAbbreviatedTypeId() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public int getFlags() {
            return this.flags_;
        }

        private void initFields() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < getArgumentCount(); i++) {
                if (!getArgument(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (hasOuterType() && !getOuterType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            for (int i = 0; i < this.argument_.size(); i++) {
                codedOutputStream.writeMessage(2, this.argument_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeMessage(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeMessage(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeInt32(14, this.abbreviatedTypeId_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 4096) == 4096 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            for (int i2 = 0; i2 < this.argument_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                computeInt32Size += CodedOutputStream.computeBoolSize(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                computeInt32Size += CodedOutputStream.computeMessageSize(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                computeInt32Size += CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                computeInt32Size += CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                computeInt32Size += CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                computeInt32Size += CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
            }
            int extensionsSerializedSize = computeInt32Size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Type type) {
            return newBuilder().mergeFrom(type);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Type, Builder> implements TypeOrBuilder {
            private int abbreviatedTypeId_;
            private Type abbreviatedType_ = Type.getDefaultInstance();
            private List<Argument> argument_ = Collections.emptyList();
            private int bitField0_;
            private int className_;
            private int flags_;
            private int flexibleTypeCapabilitiesId_;
            private int flexibleUpperBoundId_;
            private Type flexibleUpperBound_ = Type.getDefaultInstance();
            private boolean nullable_;
            private int outerTypeId_;
            private Type outerType_ = Type.getDefaultInstance();
            private int typeAliasName_;
            private int typeParameterName_;
            private int typeParameter_;

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            public Type build() {
                Type buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public Type buildPartial() {
                Type type = new Type((GeneratedMessageLite.ExtendableBuilder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) == 1) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= -2;
                }
                List unused = type.argument_ = this.argument_;
                if ((i & 2) != 2) {
                    i2 = 0;
                }
                boolean unused2 = type.nullable_ = this.nullable_;
                if ((i & 4) == 4) {
                    i2 |= 2;
                }
                int unused3 = type.flexibleTypeCapabilitiesId_ = this.flexibleTypeCapabilitiesId_;
                if ((i & 8) == 8) {
                    i2 |= 4;
                }
                Type unused4 = type.flexibleUpperBound_ = this.flexibleUpperBound_;
                if ((i & 16) == 16) {
                    i2 |= 8;
                }
                int unused5 = type.flexibleUpperBoundId_ = this.flexibleUpperBoundId_;
                if ((i & 32) == 32) {
                    i2 |= 16;
                }
                int unused6 = type.className_ = this.className_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                int unused7 = type.typeParameter_ = this.typeParameter_;
                if ((i & 128) == 128) {
                    i2 |= 64;
                }
                int unused8 = type.typeParameterName_ = this.typeParameterName_;
                if ((i & 256) == 256) {
                    i2 |= 128;
                }
                int unused9 = type.typeAliasName_ = this.typeAliasName_;
                if ((i & 512) == 512) {
                    i2 |= 256;
                }
                Type unused10 = type.outerType_ = this.outerType_;
                if ((i & 1024) == 1024) {
                    i2 |= 512;
                }
                int unused11 = type.outerTypeId_ = this.outerTypeId_;
                if ((i & 2048) == 2048) {
                    i2 |= 1024;
                }
                Type unused12 = type.abbreviatedType_ = this.abbreviatedType_;
                if ((i & 4096) == 4096) {
                    i2 |= 2048;
                }
                int unused13 = type.abbreviatedTypeId_ = this.abbreviatedTypeId_;
                if ((i & 8192) == 8192) {
                    i2 |= 4096;
                }
                int unused14 = type.flags_ = this.flags_;
                int unused15 = type.bitField0_ = i2;
                return type;
            }

            public Builder mergeFrom(Type type) {
                if (type == Type.getDefaultInstance()) {
                    return this;
                }
                if (!type.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = type.argument_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureArgumentIsMutable();
                        this.argument_.addAll(type.argument_);
                    }
                }
                if (type.hasNullable()) {
                    setNullable(type.getNullable());
                }
                if (type.hasFlexibleTypeCapabilitiesId()) {
                    setFlexibleTypeCapabilitiesId(type.getFlexibleTypeCapabilitiesId());
                }
                if (type.hasFlexibleUpperBound()) {
                    mergeFlexibleUpperBound(type.getFlexibleUpperBound());
                }
                if (type.hasFlexibleUpperBoundId()) {
                    setFlexibleUpperBoundId(type.getFlexibleUpperBoundId());
                }
                if (type.hasClassName()) {
                    setClassName(type.getClassName());
                }
                if (type.hasTypeParameter()) {
                    setTypeParameter(type.getTypeParameter());
                }
                if (type.hasTypeParameterName()) {
                    setTypeParameterName(type.getTypeParameterName());
                }
                if (type.hasTypeAliasName()) {
                    setTypeAliasName(type.getTypeAliasName());
                }
                if (type.hasOuterType()) {
                    mergeOuterType(type.getOuterType());
                }
                if (type.hasOuterTypeId()) {
                    setOuterTypeId(type.getOuterTypeId());
                }
                if (type.hasAbbreviatedType()) {
                    mergeAbbreviatedType(type.getAbbreviatedType());
                }
                if (type.hasAbbreviatedTypeId()) {
                    setAbbreviatedTypeId(type.getAbbreviatedTypeId());
                }
                if (type.hasFlags()) {
                    setFlags(type.getFlags());
                }
                mergeExtensionFields(type);
                setUnknownFields(getUnknownFields().concat(type.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getArgumentCount(); i++) {
                    if (!getArgument(i).isInitialized()) {
                        return false;
                    }
                }
                if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                    return false;
                }
                if (hasOuterType() && !getOuterType().isInitialized()) {
                    return false;
                }
                if ((!hasAbbreviatedType() || getAbbreviatedType().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Type type;
                Type type2 = null;
                try {
                    Type parsePartialFrom = Type.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    type = (Type) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    type2 = type;
                }
                if (type2 != null) {
                    mergeFrom(type2);
                }
                throw th;
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.argument_ = new ArrayList(this.argument_);
                    this.bitField0_ |= 1;
                }
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public Argument getArgument(int i) {
                return this.argument_.get(i);
            }

            public Builder setNullable(boolean z) {
                this.bitField0_ |= 2;
                this.nullable_ = z;
                return this;
            }

            public Builder setFlexibleTypeCapabilitiesId(int i) {
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = i;
                return this;
            }

            public boolean hasFlexibleUpperBound() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type getFlexibleUpperBound() {
                return this.flexibleUpperBound_;
            }

            public Builder mergeFlexibleUpperBound(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.flexibleUpperBound_ == Type.getDefaultInstance()) {
                    this.flexibleUpperBound_ = type;
                } else {
                    this.flexibleUpperBound_ = Type.newBuilder(this.flexibleUpperBound_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setFlexibleUpperBoundId(int i) {
                this.bitField0_ |= 16;
                this.flexibleUpperBoundId_ = i;
                return this;
            }

            public Builder setClassName(int i) {
                this.bitField0_ |= 32;
                this.className_ = i;
                return this;
            }

            public Builder setTypeParameter(int i) {
                this.bitField0_ |= 64;
                this.typeParameter_ = i;
                return this;
            }

            public Builder setTypeParameterName(int i) {
                this.bitField0_ |= 128;
                this.typeParameterName_ = i;
                return this;
            }

            public Builder setTypeAliasName(int i) {
                this.bitField0_ |= 256;
                this.typeAliasName_ = i;
                return this;
            }

            public boolean hasOuterType() {
                return (this.bitField0_ & 512) == 512;
            }

            public Type getOuterType() {
                return this.outerType_;
            }

            public Builder mergeOuterType(Type type) {
                if ((this.bitField0_ & 512) != 512 || this.outerType_ == Type.getDefaultInstance()) {
                    this.outerType_ = type;
                } else {
                    this.outerType_ = Type.newBuilder(this.outerType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 512;
                return this;
            }

            public Builder setOuterTypeId(int i) {
                this.bitField0_ |= 1024;
                this.outerTypeId_ = i;
                return this;
            }

            public boolean hasAbbreviatedType() {
                return (this.bitField0_ & 2048) == 2048;
            }

            public Type getAbbreviatedType() {
                return this.abbreviatedType_;
            }

            public Builder mergeAbbreviatedType(Type type) {
                if ((this.bitField0_ & 2048) != 2048 || this.abbreviatedType_ == Type.getDefaultInstance()) {
                    this.abbreviatedType_ = type;
                } else {
                    this.abbreviatedType_ = Type.newBuilder(this.abbreviatedType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder setAbbreviatedTypeId(int i) {
                this.bitField0_ |= 4096;
                this.abbreviatedTypeId_ = i;
                return this;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 8192;
                this.flags_ = i;
                return this;
            }
        }
    }

    public static final class TypeParameter extends GeneratedMessageLite.ExtendableMessage<TypeParameter> implements TypeParameterOrBuilder {
        public static Parser<TypeParameter> PARSER = new AbstractParser<TypeParameter>() {
            public TypeParameter parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeParameter(codedInputStream, extensionRegistryLite);
            }
        };
        private static final TypeParameter defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public boolean reified_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> upperBoundId_;
        /* access modifiers changed from: private */
        public List<Type> upperBound_;
        /* access modifiers changed from: private */
        public Variance variance_;

        private TypeParameter(GeneratedMessageLite.ExtendableBuilder<TypeParameter, ?> extendableBuilder) {
            super(extendableBuilder);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private TypeParameter(boolean z) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        public TypeParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        private TypeParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.id_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.name_ = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            this.bitField0_ |= 4;
                            this.reified_ = codedInputStream.readBool();
                        } else if (readTag == 32) {
                            int readEnum = codedInputStream.readEnum();
                            Variance valueOf = Variance.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 8;
                                this.variance_ = valueOf;
                            }
                        } else if (readTag == 42) {
                            if (!(z2 & true)) {
                                this.upperBound_ = new ArrayList();
                                z2 |= true;
                            }
                            this.upperBound_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                        } else if (readTag == 48) {
                            if (!(z2 & true)) {
                                this.upperBoundId_ = new ArrayList();
                                z2 |= true;
                            }
                            this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
                        } else if (readTag == 50) {
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.upperBoundId_ = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    }
                    if (z2 & true) {
                        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
            }
            if (z2 & true) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            TypeParameter typeParameter = new TypeParameter(true);
            defaultInstance = typeParameter;
            typeParameter.initFields();
        }

        public Parser<TypeParameter> getParserForType() {
            return PARSER;
        }

        public enum Variance implements Internal.EnumLite {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2);
            
            private static Internal.EnumLiteMap<Variance> internalValueMap;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<Variance>() {
                    public Variance findValueByNumber(int i) {
                        return Variance.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int i) {
                if (i == 0) {
                    return IN;
                }
                if (i == 1) {
                    return OUT;
                }
                if (i != 2) {
                    return null;
                }
                return INV;
            }

            private Variance(int i, int i2) {
                this.value = i2;
            }
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasReified() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean getReified() {
            return this.reified_;
        }

        public boolean hasVariance() {
            return (this.bitField0_ & 8) == 8;
        }

        public Variance getVariance() {
            return this.variance_;
        }

        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public Type getUpperBound(int i) {
            return this.upperBound_.get(i);
        }

        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                for (int i = 0; i < getUpperBoundCount(); i++) {
                    if (!getUpperBound(i).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBool(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeEnum(4, this.variance_.getNumber());
            }
            for (int i = 0; i < this.upperBound_.size(); i++) {
                codedOutputStream.writeMessage(5, this.upperBound_.get(i));
            }
            if (getUpperBoundIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(50);
                codedOutputStream.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.upperBoundId_.size(); i2++) {
                codedOutputStream.writeInt32NoTag(this.upperBoundId_.get(i2).intValue());
            }
            newExtensionWriter.writeUntil(1000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeBoolSize(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
            }
            for (int i2 = 0; i2 < this.upperBound_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.upperBound_.get(i2));
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.upperBoundId_.size(); i4++) {
                i3 += CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(i4).intValue());
            }
            int i5 = computeInt32Size + i3;
            if (!getUpperBoundIdList().isEmpty()) {
                i5 = i5 + 1 + CodedOutputStream.computeInt32SizeNoTag(i3);
            }
            this.upperBoundIdMemoizedSerializedSize = i3;
            int extensionsSerializedSize = i5 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TypeParameter typeParameter) {
            return newBuilder().mergeFrom(typeParameter);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeParameter, Builder> implements TypeParameterOrBuilder {
            private int bitField0_;
            private int id_;
            private int name_;
            private boolean reified_;
            private List<Integer> upperBoundId_ = Collections.emptyList();
            private List<Type> upperBound_ = Collections.emptyList();
            private Variance variance_ = Variance.INV;

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            public TypeParameter build() {
                TypeParameter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public TypeParameter buildPartial() {
                TypeParameter typeParameter = new TypeParameter((GeneratedMessageLite.ExtendableBuilder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                int unused = typeParameter.id_ = this.id_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = typeParameter.name_ = this.name_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                boolean unused3 = typeParameter.reified_ = this.reified_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                Variance unused4 = typeParameter.variance_ = this.variance_;
                if ((this.bitField0_ & 16) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    this.bitField0_ &= -17;
                }
                List unused5 = typeParameter.upperBound_ = this.upperBound_;
                if ((this.bitField0_ & 32) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                    this.bitField0_ &= -33;
                }
                List unused6 = typeParameter.upperBoundId_ = this.upperBoundId_;
                int unused7 = typeParameter.bitField0_ = i2;
                return typeParameter;
            }

            public Builder mergeFrom(TypeParameter typeParameter) {
                if (typeParameter == TypeParameter.getDefaultInstance()) {
                    return this;
                }
                if (typeParameter.hasId()) {
                    setId(typeParameter.getId());
                }
                if (typeParameter.hasName()) {
                    setName(typeParameter.getName());
                }
                if (typeParameter.hasReified()) {
                    setReified(typeParameter.getReified());
                }
                if (typeParameter.hasVariance()) {
                    setVariance(typeParameter.getVariance());
                }
                if (!typeParameter.upperBound_.isEmpty()) {
                    if (this.upperBound_.isEmpty()) {
                        this.upperBound_ = typeParameter.upperBound_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureUpperBoundIsMutable();
                        this.upperBound_.addAll(typeParameter.upperBound_);
                    }
                }
                if (!typeParameter.upperBoundId_.isEmpty()) {
                    if (this.upperBoundId_.isEmpty()) {
                        this.upperBoundId_ = typeParameter.upperBoundId_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureUpperBoundIdIsMutable();
                        this.upperBoundId_.addAll(typeParameter.upperBoundId_);
                    }
                }
                mergeExtensionFields(typeParameter);
                setUnknownFields(getUnknownFields().concat(typeParameter.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId() || !hasName()) {
                    return false;
                }
                for (int i = 0; i < getUpperBoundCount(); i++) {
                    if (!getUpperBound(i).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeParameter typeParameter;
                TypeParameter typeParameter2 = null;
                try {
                    TypeParameter parsePartialFrom = TypeParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    typeParameter = (TypeParameter) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    typeParameter2 = typeParameter;
                }
                if (typeParameter2 != null) {
                    mergeFrom(typeParameter2);
                }
                throw th;
            }

            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            public Builder setId(int i) {
                this.bitField0_ |= 1;
                this.id_ = i;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 2;
                this.name_ = i;
                return this;
            }

            public Builder setReified(boolean z) {
                this.bitField0_ |= 4;
                this.reified_ = z;
                return this;
            }

            public Builder setVariance(Variance variance) {
                variance.getClass();
                this.bitField0_ |= 8;
                this.variance_ = variance;
                return this;
            }

            private void ensureUpperBoundIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.upperBound_ = new ArrayList(this.upperBound_);
                    this.bitField0_ |= 16;
                }
            }

            public int getUpperBoundCount() {
                return this.upperBound_.size();
            }

            public Type getUpperBound(int i) {
                return this.upperBound_.get(i);
            }

            private void ensureUpperBoundIdIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.upperBoundId_ = new ArrayList(this.upperBoundId_);
                    this.bitField0_ |= 32;
                }
            }
        }
    }

    public static final class Class extends GeneratedMessageLite.ExtendableMessage<Class> implements ClassOrBuilder {
        public static Parser<Class> PARSER = new AbstractParser<Class>() {
            public Class parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Class(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Class defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int companionObjectName_;
        /* access modifiers changed from: private */
        public List<Constructor> constructor_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> contextReceiverTypeId_;
        /* access modifiers changed from: private */
        public List<Type> contextReceiverType_;
        /* access modifiers changed from: private */
        public List<EnumEntry> enumEntry_;
        /* access modifiers changed from: private */
        public int flags_;
        /* access modifiers changed from: private */
        public int fqName_;
        /* access modifiers changed from: private */
        public List<Function> function_;
        /* access modifiers changed from: private */
        public int inlineClassUnderlyingPropertyName_;
        /* access modifiers changed from: private */
        public int inlineClassUnderlyingTypeId_;
        /* access modifiers changed from: private */
        public Type inlineClassUnderlyingType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> multiFieldValueClassUnderlyingName_;
        private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> multiFieldValueClassUnderlyingTypeId_;
        /* access modifiers changed from: private */
        public List<Type> multiFieldValueClassUnderlyingType_;
        private int nestedClassNameMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> nestedClassName_;
        /* access modifiers changed from: private */
        public List<Property> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> supertypeId_;
        /* access modifiers changed from: private */
        public List<Type> supertype_;
        /* access modifiers changed from: private */
        public List<TypeAlias> typeAlias_;
        /* access modifiers changed from: private */
        public List<TypeParameter> typeParameter_;
        /* access modifiers changed from: private */
        public TypeTable typeTable_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public VersionRequirementTable versionRequirementTable_;
        /* access modifiers changed from: private */
        public List<Integer> versionRequirement_;

        private Class(GeneratedMessageLite.ExtendableBuilder<Class, ?> extendableBuilder) {
            super(extendableBuilder);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Class(boolean z) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        public Class getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v82, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v23, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v8, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX WARNING: type inference failed for: r16v4, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder] */
        /* JADX WARNING: type inference failed for: r16v7, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder] */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x042a, code lost:
            r12 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x043a, code lost:
            r7 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x043f, code lost:
            r5 = r12;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Class(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r18, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r19) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r17 = this;
                r1 = r17
                r2 = r18
                r3 = r19
                r17.<init>()
                r4 = -1
                r1.supertypeIdMemoizedSerializedSize = r4
                r1.nestedClassNameMemoizedSerializedSize = r4
                r1.contextReceiverTypeIdMemoizedSerializedSize = r4
                r1.sealedSubclassFqNameMemoizedSerializedSize = r4
                r1.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = r4
                r1.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = r4
                r1.memoizedIsInitialized = r4
                r1.memoizedSerializedSize = r4
                r17.initFields()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r4 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r5 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r6 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r4, r5)
                r7 = 0
                r8 = r7
            L_0x0028:
                r9 = 524288(0x80000, float:7.34684E-40)
                r5 = 4194304(0x400000, float:5.877472E-39)
                r14 = 1048576(0x100000, float:1.469368E-39)
                r13 = 262144(0x40000, float:3.67342E-40)
                r11 = 128(0x80, float:1.794E-43)
                r10 = 64
                if (r7 != 0) goto L_0x0549
                int r15 = r18.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r16 = 0
                switch(r15) {
                    case 0: goto L_0x0439;
                    case 8: goto L_0x042c;
                    case 16: goto L_0x040e;
                    case 18: goto L_0x03d9;
                    case 24: goto L_0x03cc;
                    case 32: goto L_0x03bf;
                    case 42: goto L_0x03a4;
                    case 50: goto L_0x0388;
                    case 56: goto L_0x036c;
                    case 58: goto L_0x0338;
                    case 66: goto L_0x031c;
                    case 74: goto L_0x0300;
                    case 82: goto L_0x02e4;
                    case 90: goto L_0x02c8;
                    case 106: goto L_0x02ac;
                    case 128: goto L_0x028e;
                    case 130: goto L_0x0258;
                    case 136: goto L_0x0249;
                    case 146: goto L_0x021c;
                    case 152: goto L_0x020d;
                    case 162: goto L_0x01f1;
                    case 168: goto L_0x01d3;
                    case 170: goto L_0x019d;
                    case 176: goto L_0x0182;
                    case 178: goto L_0x014f;
                    case 186: goto L_0x0136;
                    case 192: goto L_0x011b;
                    case 194: goto L_0x00e8;
                    case 242: goto L_0x00bf;
                    case 248: goto L_0x00a4;
                    case 250: goto L_0x006f;
                    case 258: goto L_0x0046;
                    default: goto L_0x003f;
                }     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x003f:
                r12 = 1
                boolean r5 = r1.parseUnknownField(r2, r6, r3, r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x043c
            L_0x0046:
                int r15 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r15 = r15 & r11
                if (r15 != r11) goto L_0x0051
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r15 = r1.versionRequirementTable_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder r16 = r15.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x0051:
                r15 = r16
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r12 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.versionRequirementTable_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r15 == 0) goto L_0x0068
                r15.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r12 = r15.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.versionRequirementTable_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x0068:
                int r12 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r12 | r11
                r1.bitField0_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x006f:
                int r12 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r2.pushLimit(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r15 = r8 & r5
                if (r15 == r5) goto L_0x0089
                int r15 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r15 <= 0) goto L_0x0089
                java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r15.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.versionRequirement_ = r15     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r5
            L_0x0089:
                int r15 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r15 <= 0) goto L_0x009f
                java.util.List<java.lang.Integer> r15 = r1.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r16 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r16)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r15.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11 = 128(0x80, float:1.794E-43)
                goto L_0x0089
            L_0x009f:
                r2.popLimit(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x00a4:
                r11 = r8 & r5
                if (r11 == r5) goto L_0x00b0
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.versionRequirement_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r5
            L_0x00b0:
                java.util.List<java.lang.Integer> r11 = r1.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x00bf:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11 = r11 & r10
                if (r11 != r10) goto L_0x00ca
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r11 = r1.typeTable_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder r16 = r11.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x00ca:
                r11 = r16
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r12 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.typeTable_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r11 == 0) goto L_0x00e1
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r11 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.typeTable_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x00e1:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11 = r11 | r10
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x00e8:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & r14
                if (r12 == r14) goto L_0x0102
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0102
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.multiFieldValueClassUnderlyingTypeId_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r14
            L_0x0102:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0116
                java.util.List<java.lang.Integer> r12 = r1.multiFieldValueClassUnderlyingTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x0102
            L_0x0116:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x011b:
                r11 = r8 & r14
                if (r11 == r14) goto L_0x0127
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.multiFieldValueClassUnderlyingTypeId_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r14
            L_0x0127:
                java.util.List<java.lang.Integer> r11 = r1.multiFieldValueClassUnderlyingTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0136:
                r11 = r8 & r9
                if (r11 == r9) goto L_0x0142
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.multiFieldValueClassUnderlyingType_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r9
            L_0x0142:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r11 = r1.multiFieldValueClassUnderlyingType_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x014f:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & r13
                if (r12 == r13) goto L_0x0169
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0169
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.multiFieldValueClassUnderlyingName_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r13
            L_0x0169:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x017d
                java.util.List<java.lang.Integer> r12 = r1.multiFieldValueClassUnderlyingName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x0169
            L_0x017d:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0182:
                r11 = r8 & r13
                if (r11 == r13) goto L_0x018e
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.multiFieldValueClassUnderlyingName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r13
            L_0x018e:
                java.util.List<java.lang.Integer> r11 = r1.multiFieldValueClassUnderlyingName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x019d:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & 256(0x100, float:3.59E-43)
                r15 = 256(0x100, float:3.59E-43)
                if (r12 == r15) goto L_0x01ba
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x01ba
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.contextReceiverTypeId_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 256(0x100, float:3.59E-43)
            L_0x01ba:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x01ce
                java.util.List<java.lang.Integer> r12 = r1.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x01ba
            L_0x01ce:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x01d3:
                r11 = r8 & 256(0x100, float:3.59E-43)
                r12 = 256(0x100, float:3.59E-43)
                if (r11 == r12) goto L_0x01e2
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.contextReceiverTypeId_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 256(0x100, float:3.59E-43)
            L_0x01e2:
                java.util.List<java.lang.Integer> r11 = r1.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x01f1:
                r11 = r8 & 128(0x80, float:1.794E-43)
                r12 = 128(0x80, float:1.794E-43)
                if (r11 == r12) goto L_0x0200
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.contextReceiverType_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 128(0x80, float:1.794E-43)
            L_0x0200:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r11 = r1.contextReceiverType_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x020d:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = 32
                r11 = r11 | r12
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.inlineClassUnderlyingTypeId_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x021c:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = 16
                r11 = r11 & r12
                if (r11 != r12) goto L_0x0229
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r11 = r1.inlineClassUnderlyingType_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r16 = r11.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x0229:
                r11 = r16
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r12 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.inlineClassUnderlyingType_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r11 == 0) goto L_0x0240
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r11 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.inlineClassUnderlyingType_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x0240:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = 16
                r11 = r11 | r12
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0249:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = 8
                r11 = r11 | r12
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.inlineClassUnderlyingPropertyName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0258:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & 16384(0x4000, float:2.2959E-41)
                r15 = 16384(0x4000, float:2.2959E-41)
                if (r12 == r15) goto L_0x0275
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0275
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.sealedSubclassFqName_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 16384(0x4000, float:2.2959E-41)
            L_0x0275:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0289
                java.util.List<java.lang.Integer> r12 = r1.sealedSubclassFqName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x0275
            L_0x0289:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x028e:
                r11 = r8 & 16384(0x4000, float:2.2959E-41)
                r12 = 16384(0x4000, float:2.2959E-41)
                if (r11 == r12) goto L_0x029d
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.sealedSubclassFqName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 16384(0x4000, float:2.2959E-41)
            L_0x029d:
                java.util.List<java.lang.Integer> r11 = r1.sealedSubclassFqName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x02ac:
                r11 = r8 & 8192(0x2000, float:1.14794E-41)
                r12 = 8192(0x2000, float:1.14794E-41)
                if (r11 == r12) goto L_0x02bb
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.enumEntry_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 8192(0x2000, float:1.14794E-41)
            L_0x02bb:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r11 = r1.enumEntry_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x02c8:
                r11 = r8 & 4096(0x1000, float:5.74E-42)
                r12 = 4096(0x1000, float:5.74E-42)
                if (r11 == r12) goto L_0x02d7
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.typeAlias_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 4096(0x1000, float:5.74E-42)
            L_0x02d7:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r11 = r1.typeAlias_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x02e4:
                r11 = r8 & 2048(0x800, float:2.87E-42)
                r12 = 2048(0x800, float:2.87E-42)
                if (r11 == r12) goto L_0x02f3
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.property_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 2048(0x800, float:2.87E-42)
            L_0x02f3:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r11 = r1.property_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0300:
                r11 = r8 & 1024(0x400, float:1.435E-42)
                r12 = 1024(0x400, float:1.435E-42)
                if (r11 == r12) goto L_0x030f
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.function_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 1024(0x400, float:1.435E-42)
            L_0x030f:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r11 = r1.function_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x031c:
                r11 = r8 & 512(0x200, float:7.175E-43)
                r12 = 512(0x200, float:7.175E-43)
                if (r11 == r12) goto L_0x032b
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.constructor_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 512(0x200, float:7.175E-43)
            L_0x032b:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r11 = r1.constructor_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0338:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & 64
                if (r12 == r10) goto L_0x0353
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0353
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.nestedClassName_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 64
            L_0x0353:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0367
                java.util.List<java.lang.Integer> r12 = r1.nestedClassName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x0353
            L_0x0367:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x036c:
                r11 = r8 & 64
                if (r11 == r10) goto L_0x0379
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.nestedClassName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 64
            L_0x0379:
                java.util.List<java.lang.Integer> r11 = r1.nestedClassName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0388:
                r11 = r8 & 16
                r12 = 16
                if (r11 == r12) goto L_0x0397
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.supertype_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 16
            L_0x0397:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r11 = r1.supertype_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x03a4:
                r11 = r8 & 8
                r12 = 8
                if (r11 == r12) goto L_0x03b3
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.typeParameter_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 8
            L_0x03b3:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r11 = r1.typeParameter_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x03bf:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11 = r11 | 4
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.companionObjectName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x03cc:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11 = r11 | 2
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.fqName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x03d9:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & 32
                r15 = 32
                if (r12 == r15) goto L_0x03f6
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x03f6
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.supertypeId_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 32
            L_0x03f6:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x040a
                java.util.List<java.lang.Integer> r12 = r1.supertypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x03f6
            L_0x040a:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x040e:
                r11 = r8 & 32
                r12 = 32
                if (r11 == r12) goto L_0x041d
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.supertypeId_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 32
            L_0x041d:
                java.util.List<java.lang.Integer> r11 = r1.supertypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x042a:
                r12 = 1
                goto L_0x043f
            L_0x042c:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = 1
                r11 = r11 | r12
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.flags_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x043f
            L_0x0439:
                r12 = 1
            L_0x043a:
                r7 = r12
                goto L_0x043f
            L_0x043c:
                if (r5 != 0) goto L_0x043f
                goto L_0x043a
            L_0x043f:
                r5 = r12
                goto L_0x0028
            L_0x0442:
                r0 = move-exception
                r2 = r0
                goto L_0x045c
            L_0x0445:
                r0 = move-exception
                r2 = r0
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r3 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0442 }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0442 }
                r3.<init>(r2)     // Catch:{ all -> 0x0442 }
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r2 = r3.setUnfinishedMessage(r1)     // Catch:{ all -> 0x0442 }
                throw r2     // Catch:{ all -> 0x0442 }
            L_0x0455:
                r0 = move-exception
                r2 = r0
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r2 = r2.setUnfinishedMessage(r1)     // Catch:{ all -> 0x0442 }
                throw r2     // Catch:{ all -> 0x0442 }
            L_0x045c:
                r3 = r8 & 32
                r7 = 32
                if (r3 != r7) goto L_0x046a
                java.util.List<java.lang.Integer> r3 = r1.supertypeId_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.supertypeId_ = r3
            L_0x046a:
                r3 = r8 & 8
                r7 = 8
                if (r3 != r7) goto L_0x0478
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r3 = r1.typeParameter_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.typeParameter_ = r3
            L_0x0478:
                r3 = r8 & 16
                r7 = 16
                if (r3 != r7) goto L_0x0486
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r3 = r1.supertype_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.supertype_ = r3
            L_0x0486:
                r3 = r8 & 64
                if (r3 != r10) goto L_0x0492
                java.util.List<java.lang.Integer> r3 = r1.nestedClassName_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.nestedClassName_ = r3
            L_0x0492:
                r3 = r8 & 512(0x200, float:7.175E-43)
                r7 = 512(0x200, float:7.175E-43)
                if (r3 != r7) goto L_0x04a0
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r3 = r1.constructor_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.constructor_ = r3
            L_0x04a0:
                r3 = r8 & 1024(0x400, float:1.435E-42)
                r7 = 1024(0x400, float:1.435E-42)
                if (r3 != r7) goto L_0x04ae
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r3 = r1.function_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.function_ = r3
            L_0x04ae:
                r3 = r8 & 2048(0x800, float:2.87E-42)
                r7 = 2048(0x800, float:2.87E-42)
                if (r3 != r7) goto L_0x04bc
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r3 = r1.property_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.property_ = r3
            L_0x04bc:
                r3 = r8 & 4096(0x1000, float:5.74E-42)
                r7 = 4096(0x1000, float:5.74E-42)
                if (r3 != r7) goto L_0x04ca
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r3 = r1.typeAlias_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.typeAlias_ = r3
            L_0x04ca:
                r3 = r8 & 8192(0x2000, float:1.14794E-41)
                r7 = 8192(0x2000, float:1.14794E-41)
                if (r3 != r7) goto L_0x04d8
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r3 = r1.enumEntry_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.enumEntry_ = r3
            L_0x04d8:
                r3 = r8 & 16384(0x4000, float:2.2959E-41)
                r7 = 16384(0x4000, float:2.2959E-41)
                if (r3 != r7) goto L_0x04e6
                java.util.List<java.lang.Integer> r3 = r1.sealedSubclassFqName_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.sealedSubclassFqName_ = r3
            L_0x04e6:
                r3 = r8 & 128(0x80, float:1.794E-43)
                r7 = 128(0x80, float:1.794E-43)
                if (r3 != r7) goto L_0x04f4
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r3 = r1.contextReceiverType_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.contextReceiverType_ = r3
            L_0x04f4:
                r3 = r8 & 256(0x100, float:3.59E-43)
                r7 = 256(0x100, float:3.59E-43)
                if (r3 != r7) goto L_0x0502
                java.util.List<java.lang.Integer> r3 = r1.contextReceiverTypeId_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.contextReceiverTypeId_ = r3
            L_0x0502:
                r3 = r8 & r13
                if (r3 != r13) goto L_0x050e
                java.util.List<java.lang.Integer> r3 = r1.multiFieldValueClassUnderlyingName_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.multiFieldValueClassUnderlyingName_ = r3
            L_0x050e:
                r3 = r8 & r9
                if (r3 != r9) goto L_0x051a
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r3 = r1.multiFieldValueClassUnderlyingType_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.multiFieldValueClassUnderlyingType_ = r3
            L_0x051a:
                r3 = r8 & r14
                if (r3 != r14) goto L_0x0526
                java.util.List<java.lang.Integer> r3 = r1.multiFieldValueClassUnderlyingTypeId_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.multiFieldValueClassUnderlyingTypeId_ = r3
            L_0x0526:
                r3 = r8 & r5
                if (r3 != r5) goto L_0x0532
                java.util.List<java.lang.Integer> r3 = r1.versionRequirement_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.versionRequirement_ = r3
            L_0x0532:
                r6.flush()     // Catch:{ IOException -> 0x0535, all -> 0x053c }
            L_0x0535:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r3 = r4.toByteString()
                r1.unknownFields = r3
                goto L_0x0545
            L_0x053c:
                r0 = move-exception
                r2 = r0
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r3 = r4.toByteString()
                r1.unknownFields = r3
                throw r2
            L_0x0545:
                r17.makeExtensionsImmutable()
                throw r2
            L_0x0549:
                r2 = r8 & 32
                r3 = 32
                if (r2 != r3) goto L_0x0557
                java.util.List<java.lang.Integer> r2 = r1.supertypeId_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.supertypeId_ = r2
            L_0x0557:
                r2 = r8 & 8
                r3 = 8
                if (r2 != r3) goto L_0x0565
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r2 = r1.typeParameter_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.typeParameter_ = r2
            L_0x0565:
                r2 = r8 & 16
                r3 = 16
                if (r2 != r3) goto L_0x0573
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r2 = r1.supertype_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.supertype_ = r2
            L_0x0573:
                r2 = r8 & 64
                if (r2 != r10) goto L_0x057f
                java.util.List<java.lang.Integer> r2 = r1.nestedClassName_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.nestedClassName_ = r2
            L_0x057f:
                r2 = r8 & 512(0x200, float:7.175E-43)
                r3 = 512(0x200, float:7.175E-43)
                if (r2 != r3) goto L_0x058d
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r2 = r1.constructor_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.constructor_ = r2
            L_0x058d:
                r2 = r8 & 1024(0x400, float:1.435E-42)
                r3 = 1024(0x400, float:1.435E-42)
                if (r2 != r3) goto L_0x059b
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r2 = r1.function_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.function_ = r2
            L_0x059b:
                r2 = r8 & 2048(0x800, float:2.87E-42)
                r3 = 2048(0x800, float:2.87E-42)
                if (r2 != r3) goto L_0x05a9
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r2 = r1.property_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.property_ = r2
            L_0x05a9:
                r2 = r8 & 4096(0x1000, float:5.74E-42)
                r3 = 4096(0x1000, float:5.74E-42)
                if (r2 != r3) goto L_0x05b7
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r2 = r1.typeAlias_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.typeAlias_ = r2
            L_0x05b7:
                r2 = r8 & 8192(0x2000, float:1.14794E-41)
                r3 = 8192(0x2000, float:1.14794E-41)
                if (r2 != r3) goto L_0x05c5
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r2 = r1.enumEntry_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.enumEntry_ = r2
            L_0x05c5:
                r2 = r8 & 16384(0x4000, float:2.2959E-41)
                r3 = 16384(0x4000, float:2.2959E-41)
                if (r2 != r3) goto L_0x05d3
                java.util.List<java.lang.Integer> r2 = r1.sealedSubclassFqName_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.sealedSubclassFqName_ = r2
            L_0x05d3:
                r2 = r8 & 128(0x80, float:1.794E-43)
                r3 = 128(0x80, float:1.794E-43)
                if (r2 != r3) goto L_0x05e1
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r2 = r1.contextReceiverType_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.contextReceiverType_ = r2
            L_0x05e1:
                r2 = r8 & 256(0x100, float:3.59E-43)
                r3 = 256(0x100, float:3.59E-43)
                if (r2 != r3) goto L_0x05ef
                java.util.List<java.lang.Integer> r2 = r1.contextReceiverTypeId_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.contextReceiverTypeId_ = r2
            L_0x05ef:
                r2 = r8 & r13
                if (r2 != r13) goto L_0x05fb
                java.util.List<java.lang.Integer> r2 = r1.multiFieldValueClassUnderlyingName_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.multiFieldValueClassUnderlyingName_ = r2
            L_0x05fb:
                r2 = r8 & r9
                if (r2 != r9) goto L_0x0607
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r2 = r1.multiFieldValueClassUnderlyingType_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.multiFieldValueClassUnderlyingType_ = r2
            L_0x0607:
                r2 = r8 & r14
                if (r2 != r14) goto L_0x0613
                java.util.List<java.lang.Integer> r2 = r1.multiFieldValueClassUnderlyingTypeId_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.multiFieldValueClassUnderlyingTypeId_ = r2
            L_0x0613:
                r2 = r8 & r5
                if (r2 != r5) goto L_0x061f
                java.util.List<java.lang.Integer> r2 = r1.versionRequirement_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.versionRequirement_ = r2
            L_0x061f:
                r6.flush()     // Catch:{ IOException -> 0x0622, all -> 0x0629 }
            L_0x0622:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r2 = r4.toByteString()
                r1.unknownFields = r2
                goto L_0x0632
            L_0x0629:
                r0 = move-exception
                r2 = r0
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r3 = r4.toByteString()
                r1.unknownFields = r3
                throw r2
            L_0x0632:
                r17.makeExtensionsImmutable()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            Class classR = new Class(true);
            defaultInstance = classR;
            classR.initFields();
        }

        public Parser<Class> getParserForType() {
            return PARSER;
        }

        public enum Kind implements Internal.EnumLite {
            CLASS(0, 0),
            INTERFACE(1, 1),
            ENUM_CLASS(2, 2),
            ENUM_ENTRY(3, 3),
            ANNOTATION_CLASS(4, 4),
            OBJECT(5, 5),
            COMPANION_OBJECT(6, 6);
            
            private static Internal.EnumLiteMap<Kind> internalValueMap;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<Kind>() {
                    public Kind findValueByNumber(int i) {
                        return Kind.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int i) {
                switch (i) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }

            private Kind(int i, int i2) {
                this.value = i2;
            }
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasFqName() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getFqName() {
            return this.fqName_;
        }

        public boolean hasCompanionObjectName() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int i) {
            return this.typeParameter_.get(i);
        }

        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public Type getSupertype(int i) {
            return this.supertype_.get(i);
        }

        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public Type getContextReceiverType(int i) {
            return this.contextReceiverType_.get(i);
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public Constructor getConstructor(int i) {
            return this.constructor_.get(i);
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public Function getFunction(int i) {
            return this.function_.get(i);
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public Property getProperty(int i) {
            return this.property_.get(i);
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public TypeAlias getTypeAlias(int i) {
            return this.typeAlias_.get(i);
        }

        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public EnumEntry getEnumEntry(int i) {
            return this.enumEntry_.get(i);
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        public boolean hasInlineClassUnderlyingPropertyName() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        public boolean hasInlineClassUnderlyingType() {
            return (this.bitField0_ & 16) == 16;
        }

        public Type getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        public boolean hasInlineClassUnderlyingTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
            return this.multiFieldValueClassUnderlyingName_;
        }

        public int getMultiFieldValueClassUnderlyingNameCount() {
            return this.multiFieldValueClassUnderlyingName_.size();
        }

        public List<Type> getMultiFieldValueClassUnderlyingTypeList() {
            return this.multiFieldValueClassUnderlyingType_;
        }

        public int getMultiFieldValueClassUnderlyingTypeCount() {
            return this.multiFieldValueClassUnderlyingType_.size();
        }

        public Type getMultiFieldValueClassUnderlyingType(int i) {
            return this.multiFieldValueClassUnderlyingType_.get(i);
        }

        public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
            return this.multiFieldValueClassUnderlyingTypeId_;
        }

        public int getMultiFieldValueClassUnderlyingTypeIdCount() {
            return this.multiFieldValueClassUnderlyingTypeId_.size();
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 64) == 64;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 128) == 128;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!hasFqName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getTypeParameterCount(); i++) {
                if (!getTypeParameter(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < getSupertypeCount(); i2++) {
                if (!getSupertype(i2).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < getContextReceiverTypeCount(); i3++) {
                if (!getContextReceiverType(i3).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < getConstructorCount(); i4++) {
                if (!getConstructor(i4).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < getFunctionCount(); i5++) {
                if (!getFunction(i5).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i6 = 0; i6 < getPropertyCount(); i6++) {
                if (!getProperty(i6).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i7 = 0; i7 < getTypeAliasCount(); i7++) {
                if (!getTypeAlias(i7).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i8 = 0; i8 < getEnumEntryCount(); i8++) {
                if (!getEnumEntry(i8).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!hasInlineClassUnderlyingType() || getInlineClassUnderlyingType().isInitialized()) {
                for (int i9 = 0; i9 < getMultiFieldValueClassUnderlyingTypeCount(); i9++) {
                    if (!getMultiFieldValueClassUnderlyingType(i9).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (hasTypeTable() && !getTypeTable().isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = 1;
                    return true;
                }
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if (getSupertypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(18);
                codedOutputStream.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
            }
            for (int i = 0; i < this.supertypeId_.size(); i++) {
                codedOutputStream.writeInt32NoTag(this.supertypeId_.get(i).intValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(4, this.companionObjectName_);
            }
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                codedOutputStream.writeMessage(5, this.typeParameter_.get(i2));
            }
            for (int i3 = 0; i3 < this.supertype_.size(); i3++) {
                codedOutputStream.writeMessage(6, this.supertype_.get(i3));
            }
            if (getNestedClassNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(58);
                codedOutputStream.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.nestedClassName_.size(); i4++) {
                codedOutputStream.writeInt32NoTag(this.nestedClassName_.get(i4).intValue());
            }
            for (int i5 = 0; i5 < this.constructor_.size(); i5++) {
                codedOutputStream.writeMessage(8, this.constructor_.get(i5));
            }
            for (int i6 = 0; i6 < this.function_.size(); i6++) {
                codedOutputStream.writeMessage(9, this.function_.get(i6));
            }
            for (int i7 = 0; i7 < this.property_.size(); i7++) {
                codedOutputStream.writeMessage(10, this.property_.get(i7));
            }
            for (int i8 = 0; i8 < this.typeAlias_.size(); i8++) {
                codedOutputStream.writeMessage(11, this.typeAlias_.get(i8));
            }
            for (int i9 = 0; i9 < this.enumEntry_.size(); i9++) {
                codedOutputStream.writeMessage(13, this.enumEntry_.get(i9));
            }
            if (getSealedSubclassFqNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(130);
                codedOutputStream.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
            }
            for (int i10 = 0; i10 < this.sealedSubclassFqName_.size(); i10++) {
                codedOutputStream.writeInt32NoTag(this.sealedSubclassFqName_.get(i10).intValue());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(19, this.inlineClassUnderlyingTypeId_);
            }
            for (int i11 = 0; i11 < this.contextReceiverType_.size(); i11++) {
                codedOutputStream.writeMessage(20, this.contextReceiverType_.get(i11));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(170);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i12 = 0; i12 < this.contextReceiverTypeId_.size(); i12++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i12).intValue());
            }
            if (getMultiFieldValueClassUnderlyingNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(178);
                codedOutputStream.writeRawVarint32(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
            }
            for (int i13 = 0; i13 < this.multiFieldValueClassUnderlyingName_.size(); i13++) {
                codedOutputStream.writeInt32NoTag(this.multiFieldValueClassUnderlyingName_.get(i13).intValue());
            }
            for (int i14 = 0; i14 < this.multiFieldValueClassUnderlyingType_.size(); i14++) {
                codedOutputStream.writeMessage(23, this.multiFieldValueClassUnderlyingType_.get(i14));
            }
            if (getMultiFieldValueClassUnderlyingTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(194);
                codedOutputStream.writeRawVarint32(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
            }
            for (int i15 = 0; i15 < this.multiFieldValueClassUnderlyingTypeId_.size(); i15++) {
                codedOutputStream.writeInt32NoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i15).intValue());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            for (int i16 = 0; i16 < this.versionRequirement_.size(); i16++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i16).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(32, this.versionRequirementTable_);
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.supertypeId_.size(); i3++) {
                i2 += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i3).intValue());
            }
            int i4 = computeInt32Size + i2;
            if (!getSupertypeIdList().isEmpty()) {
                i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(i2);
            }
            this.supertypeIdMemoizedSerializedSize = i2;
            if ((this.bitField0_ & 2) == 2) {
                i4 += CodedOutputStream.computeInt32Size(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i4 += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
            }
            for (int i5 = 0; i5 < this.typeParameter_.size(); i5++) {
                i4 += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i5));
            }
            for (int i6 = 0; i6 < this.supertype_.size(); i6++) {
                i4 += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i6));
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.nestedClassName_.size(); i8++) {
                i7 += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i8).intValue());
            }
            int i9 = i4 + i7;
            if (!getNestedClassNameList().isEmpty()) {
                i9 = i9 + 1 + CodedOutputStream.computeInt32SizeNoTag(i7);
            }
            this.nestedClassNameMemoizedSerializedSize = i7;
            for (int i10 = 0; i10 < this.constructor_.size(); i10++) {
                i9 += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i10));
            }
            for (int i11 = 0; i11 < this.function_.size(); i11++) {
                i9 += CodedOutputStream.computeMessageSize(9, this.function_.get(i11));
            }
            for (int i12 = 0; i12 < this.property_.size(); i12++) {
                i9 += CodedOutputStream.computeMessageSize(10, this.property_.get(i12));
            }
            for (int i13 = 0; i13 < this.typeAlias_.size(); i13++) {
                i9 += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i13));
            }
            for (int i14 = 0; i14 < this.enumEntry_.size(); i14++) {
                i9 += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i14));
            }
            int i15 = 0;
            for (int i16 = 0; i16 < this.sealedSubclassFqName_.size(); i16++) {
                i15 += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i16).intValue());
            }
            int i17 = i9 + i15;
            if (!getSealedSubclassFqNameList().isEmpty()) {
                i17 = i17 + 2 + CodedOutputStream.computeInt32SizeNoTag(i15);
            }
            this.sealedSubclassFqNameMemoizedSerializedSize = i15;
            if ((this.bitField0_ & 8) == 8) {
                i17 += CodedOutputStream.computeInt32Size(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i17 += CodedOutputStream.computeMessageSize(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i17 += CodedOutputStream.computeInt32Size(19, this.inlineClassUnderlyingTypeId_);
            }
            for (int i18 = 0; i18 < this.contextReceiverType_.size(); i18++) {
                i17 += CodedOutputStream.computeMessageSize(20, this.contextReceiverType_.get(i18));
            }
            int i19 = 0;
            for (int i20 = 0; i20 < this.contextReceiverTypeId_.size(); i20++) {
                i19 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i20).intValue());
            }
            int i21 = i17 + i19;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i21 = i21 + 2 + CodedOutputStream.computeInt32SizeNoTag(i19);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i19;
            int i22 = 0;
            for (int i23 = 0; i23 < this.multiFieldValueClassUnderlyingName_.size(); i23++) {
                i22 += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingName_.get(i23).intValue());
            }
            int i24 = i21 + i22;
            if (!getMultiFieldValueClassUnderlyingNameList().isEmpty()) {
                i24 = i24 + 2 + CodedOutputStream.computeInt32SizeNoTag(i22);
            }
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = i22;
            for (int i25 = 0; i25 < this.multiFieldValueClassUnderlyingType_.size(); i25++) {
                i24 += CodedOutputStream.computeMessageSize(23, this.multiFieldValueClassUnderlyingType_.get(i25));
            }
            int i26 = 0;
            for (int i27 = 0; i27 < this.multiFieldValueClassUnderlyingTypeId_.size(); i27++) {
                i26 += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i27).intValue());
            }
            int i28 = i24 + i26;
            if (!getMultiFieldValueClassUnderlyingTypeIdList().isEmpty()) {
                i28 = i28 + 2 + CodedOutputStream.computeInt32SizeNoTag(i26);
            }
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = i26;
            if ((this.bitField0_ & 64) == 64) {
                i28 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            int i29 = 0;
            for (int i30 = 0; i30 < this.versionRequirement_.size(); i30++) {
                i29 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i30).intValue());
            }
            int size = i28 + i29 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 128) == 128) {
                size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static Class parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Class classR) {
            return newBuilder().mergeFrom(classR);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Class, Builder> implements ClassOrBuilder {
            private int bitField0_;
            private int companionObjectName_;
            private List<Constructor> constructor_ = Collections.emptyList();
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private List<EnumEntry> enumEntry_ = Collections.emptyList();
            private int flags_ = 6;
            private int fqName_;
            private List<Function> function_ = Collections.emptyList();
            private int inlineClassUnderlyingPropertyName_;
            private int inlineClassUnderlyingTypeId_;
            private Type inlineClassUnderlyingType_ = Type.getDefaultInstance();
            private List<Integer> multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            private List<Integer> multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            private List<Type> multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            private List<Integer> nestedClassName_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<Integer> sealedSubclassFqName_ = Collections.emptyList();
            private List<Integer> supertypeId_ = Collections.emptyList();
            private List<Type> supertype_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            public Class build() {
                Class buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public Class buildPartial() {
                Class classR = new Class((GeneratedMessageLite.ExtendableBuilder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                int unused = classR.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = classR.fqName_ = this.fqName_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                int unused3 = classR.companionObjectName_ = this.companionObjectName_;
                if ((this.bitField0_ & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -9;
                }
                List unused4 = classR.typeParameter_ = this.typeParameter_;
                if ((this.bitField0_ & 16) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    this.bitField0_ &= -17;
                }
                List unused5 = classR.supertype_ = this.supertype_;
                if ((this.bitField0_ & 32) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    this.bitField0_ &= -33;
                }
                List unused6 = classR.supertypeId_ = this.supertypeId_;
                if ((this.bitField0_ & 64) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    this.bitField0_ &= -65;
                }
                List unused7 = classR.nestedClassName_ = this.nestedClassName_;
                if ((this.bitField0_ & 128) == 128) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -129;
                }
                List unused8 = classR.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -257;
                }
                List unused9 = classR.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((this.bitField0_ & 512) == 512) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    this.bitField0_ &= -513;
                }
                List unused10 = classR.constructor_ = this.constructor_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= -1025;
                }
                List unused11 = classR.function_ = this.function_;
                if ((this.bitField0_ & 2048) == 2048) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= -2049;
                }
                List unused12 = classR.property_ = this.property_;
                if ((this.bitField0_ & 4096) == 4096) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= -4097;
                }
                List unused13 = classR.typeAlias_ = this.typeAlias_;
                if ((this.bitField0_ & 8192) == 8192) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    this.bitField0_ &= -8193;
                }
                List unused14 = classR.enumEntry_ = this.enumEntry_;
                if ((this.bitField0_ & 16384) == 16384) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    this.bitField0_ &= -16385;
                }
                List unused15 = classR.sealedSubclassFqName_ = this.sealedSubclassFqName_;
                if ((i & 32768) == 32768) {
                    i2 |= 8;
                }
                int unused16 = classR.inlineClassUnderlyingPropertyName_ = this.inlineClassUnderlyingPropertyName_;
                if ((i & 65536) == 65536) {
                    i2 |= 16;
                }
                Type unused17 = classR.inlineClassUnderlyingType_ = this.inlineClassUnderlyingType_;
                if ((i & 131072) == 131072) {
                    i2 |= 32;
                }
                int unused18 = classR.inlineClassUnderlyingTypeId_ = this.inlineClassUnderlyingTypeId_;
                if ((this.bitField0_ & 262144) == 262144) {
                    this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                    this.bitField0_ &= -262145;
                }
                List unused19 = classR.multiFieldValueClassUnderlyingName_ = this.multiFieldValueClassUnderlyingName_;
                if ((this.bitField0_ & 524288) == 524288) {
                    this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                    this.bitField0_ &= -524289;
                }
                List unused20 = classR.multiFieldValueClassUnderlyingType_ = this.multiFieldValueClassUnderlyingType_;
                if ((this.bitField0_ & 1048576) == 1048576) {
                    this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                    this.bitField0_ &= -1048577;
                }
                List unused21 = classR.multiFieldValueClassUnderlyingTypeId_ = this.multiFieldValueClassUnderlyingTypeId_;
                if ((i & 2097152) == 2097152) {
                    i2 |= 64;
                }
                TypeTable unused22 = classR.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 4194304) == 4194304) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -4194305;
                }
                List unused23 = classR.versionRequirement_ = this.versionRequirement_;
                if ((i & 8388608) == 8388608) {
                    i2 |= 128;
                }
                VersionRequirementTable unused24 = classR.versionRequirementTable_ = this.versionRequirementTable_;
                int unused25 = classR.bitField0_ = i2;
                return classR;
            }

            public Builder mergeFrom(Class classR) {
                if (classR == Class.getDefaultInstance()) {
                    return this;
                }
                if (classR.hasFlags()) {
                    setFlags(classR.getFlags());
                }
                if (classR.hasFqName()) {
                    setFqName(classR.getFqName());
                }
                if (classR.hasCompanionObjectName()) {
                    setCompanionObjectName(classR.getCompanionObjectName());
                }
                if (!classR.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = classR.typeParameter_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(classR.typeParameter_);
                    }
                }
                if (!classR.supertype_.isEmpty()) {
                    if (this.supertype_.isEmpty()) {
                        this.supertype_ = classR.supertype_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureSupertypeIsMutable();
                        this.supertype_.addAll(classR.supertype_);
                    }
                }
                if (!classR.supertypeId_.isEmpty()) {
                    if (this.supertypeId_.isEmpty()) {
                        this.supertypeId_ = classR.supertypeId_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureSupertypeIdIsMutable();
                        this.supertypeId_.addAll(classR.supertypeId_);
                    }
                }
                if (!classR.nestedClassName_.isEmpty()) {
                    if (this.nestedClassName_.isEmpty()) {
                        this.nestedClassName_ = classR.nestedClassName_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureNestedClassNameIsMutable();
                        this.nestedClassName_.addAll(classR.nestedClassName_);
                    }
                }
                if (!classR.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = classR.contextReceiverType_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(classR.contextReceiverType_);
                    }
                }
                if (!classR.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = classR.contextReceiverTypeId_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(classR.contextReceiverTypeId_);
                    }
                }
                if (!classR.constructor_.isEmpty()) {
                    if (this.constructor_.isEmpty()) {
                        this.constructor_ = classR.constructor_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureConstructorIsMutable();
                        this.constructor_.addAll(classR.constructor_);
                    }
                }
                if (!classR.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = classR.function_;
                        this.bitField0_ &= -1025;
                    } else {
                        ensureFunctionIsMutable();
                        this.function_.addAll(classR.function_);
                    }
                }
                if (!classR.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = classR.property_;
                        this.bitField0_ &= -2049;
                    } else {
                        ensurePropertyIsMutable();
                        this.property_.addAll(classR.property_);
                    }
                }
                if (!classR.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = classR.typeAlias_;
                        this.bitField0_ &= -4097;
                    } else {
                        ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(classR.typeAlias_);
                    }
                }
                if (!classR.enumEntry_.isEmpty()) {
                    if (this.enumEntry_.isEmpty()) {
                        this.enumEntry_ = classR.enumEntry_;
                        this.bitField0_ &= -8193;
                    } else {
                        ensureEnumEntryIsMutable();
                        this.enumEntry_.addAll(classR.enumEntry_);
                    }
                }
                if (!classR.sealedSubclassFqName_.isEmpty()) {
                    if (this.sealedSubclassFqName_.isEmpty()) {
                        this.sealedSubclassFqName_ = classR.sealedSubclassFqName_;
                        this.bitField0_ &= -16385;
                    } else {
                        ensureSealedSubclassFqNameIsMutable();
                        this.sealedSubclassFqName_.addAll(classR.sealedSubclassFqName_);
                    }
                }
                if (classR.hasInlineClassUnderlyingPropertyName()) {
                    setInlineClassUnderlyingPropertyName(classR.getInlineClassUnderlyingPropertyName());
                }
                if (classR.hasInlineClassUnderlyingType()) {
                    mergeInlineClassUnderlyingType(classR.getInlineClassUnderlyingType());
                }
                if (classR.hasInlineClassUnderlyingTypeId()) {
                    setInlineClassUnderlyingTypeId(classR.getInlineClassUnderlyingTypeId());
                }
                if (!classR.multiFieldValueClassUnderlyingName_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingName_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingName_ = classR.multiFieldValueClassUnderlyingName_;
                        this.bitField0_ &= -262145;
                    } else {
                        ensureMultiFieldValueClassUnderlyingNameIsMutable();
                        this.multiFieldValueClassUnderlyingName_.addAll(classR.multiFieldValueClassUnderlyingName_);
                    }
                }
                if (!classR.multiFieldValueClassUnderlyingType_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingType_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingType_ = classR.multiFieldValueClassUnderlyingType_;
                        this.bitField0_ &= -524289;
                    } else {
                        ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                        this.multiFieldValueClassUnderlyingType_.addAll(classR.multiFieldValueClassUnderlyingType_);
                    }
                }
                if (!classR.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingTypeId_ = classR.multiFieldValueClassUnderlyingTypeId_;
                        this.bitField0_ &= -1048577;
                    } else {
                        ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                        this.multiFieldValueClassUnderlyingTypeId_.addAll(classR.multiFieldValueClassUnderlyingTypeId_);
                    }
                }
                if (classR.hasTypeTable()) {
                    mergeTypeTable(classR.getTypeTable());
                }
                if (!classR.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = classR.versionRequirement_;
                        this.bitField0_ &= -4194305;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(classR.versionRequirement_);
                    }
                }
                if (classR.hasVersionRequirementTable()) {
                    mergeVersionRequirementTable(classR.getVersionRequirementTable());
                }
                mergeExtensionFields(classR);
                setUnknownFields(getUnknownFields().concat(classR.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasFqName()) {
                    return false;
                }
                for (int i = 0; i < getTypeParameterCount(); i++) {
                    if (!getTypeParameter(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < getSupertypeCount(); i2++) {
                    if (!getSupertype(i2).isInitialized()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < getContextReceiverTypeCount(); i3++) {
                    if (!getContextReceiverType(i3).isInitialized()) {
                        return false;
                    }
                }
                for (int i4 = 0; i4 < getConstructorCount(); i4++) {
                    if (!getConstructor(i4).isInitialized()) {
                        return false;
                    }
                }
                for (int i5 = 0; i5 < getFunctionCount(); i5++) {
                    if (!getFunction(i5).isInitialized()) {
                        return false;
                    }
                }
                for (int i6 = 0; i6 < getPropertyCount(); i6++) {
                    if (!getProperty(i6).isInitialized()) {
                        return false;
                    }
                }
                for (int i7 = 0; i7 < getTypeAliasCount(); i7++) {
                    if (!getTypeAlias(i7).isInitialized()) {
                        return false;
                    }
                }
                for (int i8 = 0; i8 < getEnumEntryCount(); i8++) {
                    if (!getEnumEntry(i8).isInitialized()) {
                        return false;
                    }
                }
                if (hasInlineClassUnderlyingType() && !getInlineClassUnderlyingType().isInitialized()) {
                    return false;
                }
                for (int i9 = 0; i9 < getMultiFieldValueClassUnderlyingTypeCount(); i9++) {
                    if (!getMultiFieldValueClassUnderlyingType(i9).isInitialized()) {
                        return false;
                    }
                }
                if ((!hasTypeTable() || getTypeTable().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Class classR;
                Class classR2 = null;
                try {
                    Class parsePartialFrom = Class.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    classR = (Class) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    classR2 = classR;
                }
                if (classR2 != null) {
                    mergeFrom(classR2);
                }
                throw th;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public boolean hasFqName() {
                return (this.bitField0_ & 2) == 2;
            }

            public Builder setFqName(int i) {
                this.bitField0_ |= 2;
                this.fqName_ = i;
                return this;
            }

            public Builder setCompanionObjectName(int i) {
                this.bitField0_ |= 4;
                this.companionObjectName_ = i;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 8;
                }
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int i) {
                return this.typeParameter_.get(i);
            }

            private void ensureSupertypeIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.supertype_ = new ArrayList(this.supertype_);
                    this.bitField0_ |= 16;
                }
            }

            public int getSupertypeCount() {
                return this.supertype_.size();
            }

            public Type getSupertype(int i) {
                return this.supertype_.get(i);
            }

            private void ensureSupertypeIdIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.supertypeId_ = new ArrayList(this.supertypeId_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureNestedClassNameIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.nestedClassName_ = new ArrayList(this.nestedClassName_);
                    this.bitField0_ |= 64;
                }
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 128) != 128) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 128;
                }
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Type getContextReceiverType(int i) {
                return this.contextReceiverType_.get(i);
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 256;
                }
            }

            private void ensureConstructorIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.constructor_ = new ArrayList(this.constructor_);
                    this.bitField0_ |= 512;
                }
            }

            public int getConstructorCount() {
                return this.constructor_.size();
            }

            public Constructor getConstructor(int i) {
                return this.constructor_.get(i);
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.function_ = new ArrayList(this.function_);
                    this.bitField0_ |= 1024;
                }
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Function getFunction(int i) {
                return this.function_.get(i);
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2048) != 2048) {
                    this.property_ = new ArrayList(this.property_);
                    this.bitField0_ |= 2048;
                }
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public Property getProperty(int i) {
                return this.property_.get(i);
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4096) != 4096) {
                    this.typeAlias_ = new ArrayList(this.typeAlias_);
                    this.bitField0_ |= 4096;
                }
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeAlias getTypeAlias(int i) {
                return this.typeAlias_.get(i);
            }

            private void ensureEnumEntryIsMutable() {
                if ((this.bitField0_ & 8192) != 8192) {
                    this.enumEntry_ = new ArrayList(this.enumEntry_);
                    this.bitField0_ |= 8192;
                }
            }

            public int getEnumEntryCount() {
                return this.enumEntry_.size();
            }

            public EnumEntry getEnumEntry(int i) {
                return this.enumEntry_.get(i);
            }

            private void ensureSealedSubclassFqNameIsMutable() {
                if ((this.bitField0_ & 16384) != 16384) {
                    this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
                    this.bitField0_ |= 16384;
                }
            }

            public Builder setInlineClassUnderlyingPropertyName(int i) {
                this.bitField0_ |= 32768;
                this.inlineClassUnderlyingPropertyName_ = i;
                return this;
            }

            public boolean hasInlineClassUnderlyingType() {
                return (this.bitField0_ & 65536) == 65536;
            }

            public Type getInlineClassUnderlyingType() {
                return this.inlineClassUnderlyingType_;
            }

            public Builder mergeInlineClassUnderlyingType(Type type) {
                if ((this.bitField0_ & 65536) != 65536 || this.inlineClassUnderlyingType_ == Type.getDefaultInstance()) {
                    this.inlineClassUnderlyingType_ = type;
                } else {
                    this.inlineClassUnderlyingType_ = Type.newBuilder(this.inlineClassUnderlyingType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 65536;
                return this;
            }

            public Builder setInlineClassUnderlyingTypeId(int i) {
                this.bitField0_ |= 131072;
                this.inlineClassUnderlyingTypeId_ = i;
                return this;
            }

            private void ensureMultiFieldValueClassUnderlyingNameIsMutable() {
                if ((this.bitField0_ & 262144) != 262144) {
                    this.multiFieldValueClassUnderlyingName_ = new ArrayList(this.multiFieldValueClassUnderlyingName_);
                    this.bitField0_ |= 262144;
                }
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIsMutable() {
                if ((this.bitField0_ & 524288) != 524288) {
                    this.multiFieldValueClassUnderlyingType_ = new ArrayList(this.multiFieldValueClassUnderlyingType_);
                    this.bitField0_ |= 524288;
                }
            }

            public int getMultiFieldValueClassUnderlyingTypeCount() {
                return this.multiFieldValueClassUnderlyingType_.size();
            }

            public Type getMultiFieldValueClassUnderlyingType(int i) {
                return this.multiFieldValueClassUnderlyingType_.get(i);
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIdIsMutable() {
                if ((this.bitField0_ & 1048576) != 1048576) {
                    this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList(this.multiFieldValueClassUnderlyingTypeId_);
                    this.bitField0_ |= 1048576;
                }
            }

            public boolean hasTypeTable() {
                return (this.bitField0_ & 2097152) == 2097152;
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 2097152) != 2097152 || this.typeTable_ == TypeTable.getDefaultInstance()) {
                    this.typeTable_ = typeTable;
                } else {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                }
                this.bitField0_ |= 2097152;
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4194304) != 4194304) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4194304;
                }
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                if ((this.bitField0_ & 8388608) != 8388608 || this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) {
                    this.versionRequirementTable_ = versionRequirementTable;
                } else {
                    this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(versionRequirementTable).buildPartial();
                }
                this.bitField0_ |= 8388608;
                return this;
            }
        }
    }

    public static final class Package extends GeneratedMessageLite.ExtendableMessage<Package> implements PackageOrBuilder {
        public static Parser<Package> PARSER = new AbstractParser<Package>() {
            public Package parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Package(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Package defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Property> property_;
        /* access modifiers changed from: private */
        public List<TypeAlias> typeAlias_;
        /* access modifiers changed from: private */
        public TypeTable typeTable_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public VersionRequirementTable versionRequirementTable_;

        private Package(GeneratedMessageLite.ExtendableBuilder<Package, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Package(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        public Package getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder} */
        /* JADX WARNING: type inference failed for: r9v0 */
        /* JADX WARNING: type inference failed for: r9v5 */
        /* JADX WARNING: type inference failed for: r9v6 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Package(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r11, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r12) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r10 = this;
                r10.<init>()
                r0 = -1
                r10.memoizedIsInitialized = r0
                r10.memoizedSerializedSize = r0
                r10.initFields()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r1 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r0, r1)
                r3 = 0
                r4 = r3
            L_0x0016:
                r5 = 4
                r6 = 2
                if (r3 != 0) goto L_0x012b
                int r7 = r11.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                if (r7 == 0) goto L_0x00d7
                r8 = 26
                if (r7 == r8) goto L_0x00bd
                r8 = 34
                if (r7 == r8) goto L_0x00a3
                r8 = 42
                if (r7 == r8) goto L_0x0089
                r8 = 242(0xf2, float:3.39E-43)
                r9 = 0
                if (r7 == r8) goto L_0x0063
                r8 = 258(0x102, float:3.62E-43)
                if (r7 == r8) goto L_0x003d
                boolean r5 = r10.parseUnknownField(r11, r2, r12, r7)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                if (r5 != 0) goto L_0x0016
                goto L_0x00d7
            L_0x003d:
                int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7 = r7 & r6
                if (r7 != r6) goto L_0x0048
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r7 = r10.versionRequirementTable_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder r9 = r7.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
            L_0x0048:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r11.readMessage(r7, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r12)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r7 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.versionRequirementTable_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                if (r9 == 0) goto L_0x005d
                r9.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r7)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r7 = r9.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.versionRequirementTable_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
            L_0x005d:
                int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7 = r7 | r6
                r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                goto L_0x0016
            L_0x0063:
                int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7 = r7 & r1
                if (r7 != r1) goto L_0x006e
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r7 = r10.typeTable_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder r9 = r7.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
            L_0x006e:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r11.readMessage(r7, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r12)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r7 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.typeTable_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                if (r9 == 0) goto L_0x0083
                r9.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r7)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r7 = r9.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.typeTable_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
            L_0x0083:
                int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7 = r7 | r1
                r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                goto L_0x0016
            L_0x0089:
                r7 = r4 & 4
                if (r7 == r5) goto L_0x0096
                java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.typeAlias_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r4 = r4 | 4
            L_0x0096:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r7 = r10.typeAlias_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r8 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8 = r11.readMessage(r8, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r12)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                goto L_0x0016
            L_0x00a3:
                r7 = r4 & 2
                if (r7 == r6) goto L_0x00b0
                java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.property_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r4 = r4 | 2
            L_0x00b0:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r7 = r10.property_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r8 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8 = r11.readMessage(r8, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r12)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                goto L_0x0016
            L_0x00bd:
                r7 = r4 & 1
                if (r7 == r1) goto L_0x00ca
                java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.function_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r4 = r4 | 1
            L_0x00ca:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r7 = r10.function_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r8 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8 = r11.readMessage(r8, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r12)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                goto L_0x0016
            L_0x00d7:
                r3 = r1
                goto L_0x0016
            L_0x00da:
                r11 = move-exception
                goto L_0x00f1
            L_0x00dc:
                r11 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r12 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x00da }
                java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x00da }
                r12.<init>(r11)     // Catch:{ all -> 0x00da }
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r11 = r12.setUnfinishedMessage(r10)     // Catch:{ all -> 0x00da }
                throw r11     // Catch:{ all -> 0x00da }
            L_0x00eb:
                r11 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r11 = r11.setUnfinishedMessage(r10)     // Catch:{ all -> 0x00da }
                throw r11     // Catch:{ all -> 0x00da }
            L_0x00f1:
                r12 = r4 & 1
                if (r12 != r1) goto L_0x00fd
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r12 = r10.function_
                java.util.List r12 = java.util.Collections.unmodifiableList(r12)
                r10.function_ = r12
            L_0x00fd:
                r12 = r4 & 2
                if (r12 != r6) goto L_0x0109
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r12 = r10.property_
                java.util.List r12 = java.util.Collections.unmodifiableList(r12)
                r10.property_ = r12
            L_0x0109:
                r12 = r4 & 4
                if (r12 != r5) goto L_0x0115
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r12 = r10.typeAlias_
                java.util.List r12 = java.util.Collections.unmodifiableList(r12)
                r10.typeAlias_ = r12
            L_0x0115:
                r2.flush()     // Catch:{ IOException -> 0x0118, all -> 0x011f }
            L_0x0118:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r12 = r0.toByteString()
                r10.unknownFields = r12
                goto L_0x0127
            L_0x011f:
                r11 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r12 = r0.toByteString()
                r10.unknownFields = r12
                throw r11
            L_0x0127:
                r10.makeExtensionsImmutable()
                throw r11
            L_0x012b:
                r11 = r4 & 1
                if (r11 != r1) goto L_0x0137
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r11 = r10.function_
                java.util.List r11 = java.util.Collections.unmodifiableList(r11)
                r10.function_ = r11
            L_0x0137:
                r11 = r4 & 2
                if (r11 != r6) goto L_0x0143
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r11 = r10.property_
                java.util.List r11 = java.util.Collections.unmodifiableList(r11)
                r10.property_ = r11
            L_0x0143:
                r11 = r4 & 4
                if (r11 != r5) goto L_0x014f
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r11 = r10.typeAlias_
                java.util.List r11 = java.util.Collections.unmodifiableList(r11)
                r10.typeAlias_ = r11
            L_0x014f:
                r2.flush()     // Catch:{ IOException -> 0x0152, all -> 0x0159 }
            L_0x0152:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r0.toByteString()
                r10.unknownFields = r11
                goto L_0x0161
            L_0x0159:
                r11 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r12 = r0.toByteString()
                r10.unknownFields = r12
                throw r11
            L_0x0161:
                r10.makeExtensionsImmutable()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            Package packageR = new Package(true);
            defaultInstance = packageR;
            packageR.initFields();
        }

        public Parser<Package> getParserForType() {
            return PARSER;
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public Function getFunction(int i) {
            return this.function_.get(i);
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public Property getProperty(int i) {
            return this.property_.get(i);
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public TypeAlias getTypeAlias(int i) {
            return this.typeAlias_.get(i);
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 1) == 1;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 2) == 2;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        private void initFields() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < getFunctionCount(); i++) {
                if (!getFunction(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < getPropertyCount(); i2++) {
                if (!getProperty(i2).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < getTypeAliasCount(); i3++) {
                if (!getTypeAlias(i3).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            for (int i = 0; i < this.function_.size(); i++) {
                codedOutputStream.writeMessage(3, this.function_.get(i));
            }
            for (int i2 = 0; i2 < this.property_.size(); i2++) {
                codedOutputStream.writeMessage(4, this.property_.get(i2));
            }
            for (int i3 = 0; i3 < this.typeAlias_.size(); i3++) {
                codedOutputStream.writeMessage(5, this.typeAlias_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(32, this.versionRequirementTable_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.function_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(3, this.function_.get(i3));
            }
            for (int i4 = 0; i4 < this.property_.size(); i4++) {
                i2 += CodedOutputStream.computeMessageSize(4, this.property_.get(i4));
            }
            for (int i5 = 0; i5 < this.typeAlias_.size(); i5++) {
                i2 += CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(i5));
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
            }
            int extensionsSerializedSize = i2 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static Package parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Package packageR) {
            return newBuilder().mergeFrom(packageR);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Package, Builder> implements PackageOrBuilder {
            private int bitField0_;
            private List<Function> function_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            public Package build() {
                Package buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public Package buildPartial() {
                Package packageR = new Package((GeneratedMessageLite.ExtendableBuilder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) == 1) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= -2;
                }
                List unused = packageR.function_ = this.function_;
                if ((this.bitField0_ & 2) == 2) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= -3;
                }
                List unused2 = packageR.property_ = this.property_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= -5;
                }
                List unused3 = packageR.typeAlias_ = this.typeAlias_;
                if ((i & 8) != 8) {
                    i2 = 0;
                }
                TypeTable unused4 = packageR.typeTable_ = this.typeTable_;
                if ((i & 16) == 16) {
                    i2 |= 2;
                }
                VersionRequirementTable unused5 = packageR.versionRequirementTable_ = this.versionRequirementTable_;
                int unused6 = packageR.bitField0_ = i2;
                return packageR;
            }

            public Builder mergeFrom(Package packageR) {
                if (packageR == Package.getDefaultInstance()) {
                    return this;
                }
                if (!packageR.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = packageR.function_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFunctionIsMutable();
                        this.function_.addAll(packageR.function_);
                    }
                }
                if (!packageR.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = packageR.property_;
                        this.bitField0_ &= -3;
                    } else {
                        ensurePropertyIsMutable();
                        this.property_.addAll(packageR.property_);
                    }
                }
                if (!packageR.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = packageR.typeAlias_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(packageR.typeAlias_);
                    }
                }
                if (packageR.hasTypeTable()) {
                    mergeTypeTable(packageR.getTypeTable());
                }
                if (packageR.hasVersionRequirementTable()) {
                    mergeVersionRequirementTable(packageR.getVersionRequirementTable());
                }
                mergeExtensionFields(packageR);
                setUnknownFields(getUnknownFields().concat(packageR.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getFunctionCount(); i++) {
                    if (!getFunction(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < getPropertyCount(); i2++) {
                    if (!getProperty(i2).isInitialized()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < getTypeAliasCount(); i3++) {
                    if (!getTypeAlias(i3).isInitialized()) {
                        return false;
                    }
                }
                if ((!hasTypeTable() || getTypeTable().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Package packageR;
                Package packageR2 = null;
                try {
                    Package parsePartialFrom = Package.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    packageR = (Package) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    packageR2 = packageR;
                }
                if (packageR2 != null) {
                    mergeFrom(packageR2);
                }
                throw th;
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.function_ = new ArrayList(this.function_);
                    this.bitField0_ |= 1;
                }
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Function getFunction(int i) {
                return this.function_.get(i);
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.property_ = new ArrayList(this.property_);
                    this.bitField0_ |= 2;
                }
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public Property getProperty(int i) {
                return this.property_.get(i);
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeAlias_ = new ArrayList(this.typeAlias_);
                    this.bitField0_ |= 4;
                }
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeAlias getTypeAlias(int i) {
                return this.typeAlias_.get(i);
            }

            public boolean hasTypeTable() {
                return (this.bitField0_ & 8) == 8;
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 8) != 8 || this.typeTable_ == TypeTable.getDefaultInstance()) {
                    this.typeTable_ = typeTable;
                } else {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                if ((this.bitField0_ & 16) != 16 || this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) {
                    this.versionRequirementTable_ = versionRequirementTable;
                } else {
                    this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(versionRequirementTable).buildPartial();
                }
                this.bitField0_ |= 16;
                return this;
            }
        }
    }

    public static final class TypeTable extends GeneratedMessageLite implements TypeTableOrBuilder {
        public static Parser<TypeTable> PARSER = new AbstractParser<TypeTable>() {
            public TypeTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final TypeTable defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Type> type_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        private TypeTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TypeTable(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
        }

        public TypeTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        private TypeTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2) {
                                this.type_ = new ArrayList();
                                z2 = true;
                            }
                            this.type_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                        } else if (readTag == 16) {
                            this.bitField0_ |= 1;
                            this.firstNullable_ = codedInputStream.readInt32();
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2) {
                        this.type_ = Collections.unmodifiableList(this.type_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2) {
                this.type_ = Collections.unmodifiableList(this.type_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            TypeTable typeTable = new TypeTable(true);
            defaultInstance = typeTable;
            typeTable.initFields();
        }

        public Parser<TypeTable> getParserForType() {
            return PARSER;
        }

        public List<Type> getTypeList() {
            return this.type_;
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        public Type getType(int i) {
            return this.type_.get(i);
        }

        public boolean hasFirstNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFirstNullable() {
            return this.firstNullable_;
        }

        private void initFields() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < getTypeCount(); i++) {
                if (!getType(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.type_.size(); i++) {
                codedOutputStream.writeMessage(1, this.type_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(2, this.firstNullable_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.type_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.type_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeInt32Size(2, this.firstNullable_);
            }
            int size = i2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TypeTable typeTable) {
            return newBuilder().mergeFrom(typeTable);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TypeTable, Builder> implements TypeTableOrBuilder {
            private int bitField0_;
            private int firstNullable_ = -1;
            private List<Type> type_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            public TypeTable build() {
                TypeTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public TypeTable buildPartial() {
                TypeTable typeTable = new TypeTable((GeneratedMessageLite.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) == 1) {
                    this.type_ = Collections.unmodifiableList(this.type_);
                    this.bitField0_ &= -2;
                }
                List unused = typeTable.type_ = this.type_;
                if ((i & 2) != 2) {
                    i2 = 0;
                }
                int unused2 = typeTable.firstNullable_ = this.firstNullable_;
                int unused3 = typeTable.bitField0_ = i2;
                return typeTable;
            }

            public Builder mergeFrom(TypeTable typeTable) {
                if (typeTable == TypeTable.getDefaultInstance()) {
                    return this;
                }
                if (!typeTable.type_.isEmpty()) {
                    if (this.type_.isEmpty()) {
                        this.type_ = typeTable.type_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTypeIsMutable();
                        this.type_.addAll(typeTable.type_);
                    }
                }
                if (typeTable.hasFirstNullable()) {
                    setFirstNullable(typeTable.getFirstNullable());
                }
                setUnknownFields(getUnknownFields().concat(typeTable.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getTypeCount(); i++) {
                    if (!getType(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeTable typeTable;
                TypeTable typeTable2 = null;
                try {
                    TypeTable parsePartialFrom = TypeTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    typeTable = (TypeTable) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    typeTable2 = typeTable;
                }
                if (typeTable2 != null) {
                    mergeFrom(typeTable2);
                }
                throw th;
            }

            private void ensureTypeIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.type_ = new ArrayList(this.type_);
                    this.bitField0_ |= 1;
                }
            }

            public int getTypeCount() {
                return this.type_.size();
            }

            public Type getType(int i) {
                return this.type_.get(i);
            }

            public Builder setFirstNullable(int i) {
                this.bitField0_ |= 2;
                this.firstNullable_ = i;
                return this;
            }
        }
    }

    public static final class Constructor extends GeneratedMessageLite.ExtendableMessage<Constructor> implements ConstructorOrBuilder {
        public static Parser<Constructor> PARSER = new AbstractParser<Constructor>() {
            public Constructor parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Constructor(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Constructor defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public List<ValueParameter> valueParameter_;
        /* access modifiers changed from: private */
        public List<Integer> versionRequirement_;

        private Constructor(GeneratedMessageLite.ExtendableBuilder<Constructor, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Constructor(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        public Constructor getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Constructor(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                        } else if (readTag == 18) {
                            if (!(z2 & true)) {
                                this.valueParameter_ = new ArrayList();
                                z2 |= true;
                            }
                            this.valueParameter_.add(codedInputStream.readMessage(ValueParameter.PARSER, extensionRegistryLite));
                        } else if (readTag == 248) {
                            if (!(z2 & true)) {
                                this.versionRequirement_ = new ArrayList();
                                z2 |= true;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                        } else if (readTag == 250) {
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if (z2 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
            }
            if (z2 & true) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            Constructor constructor = new Constructor(true);
            defaultInstance = constructor;
            constructor.initFields();
        }

        public Parser<Constructor> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public ValueParameter getValueParameter(int i) {
            return this.valueParameter_.get(i);
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < getValueParameterCount(); i++) {
                if (!getValueParameter(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            for (int i = 0; i < this.valueParameter_.size(); i++) {
                codedOutputStream.writeMessage(2, this.valueParameter_.get(i));
            }
            for (int i2 = 0; i2 < this.versionRequirement_.size(); i2++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i2).intValue());
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(i2));
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
                i3 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i4).intValue());
            }
            int size = computeInt32Size + i3 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Constructor constructor) {
            return newBuilder().mergeFrom(constructor);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Constructor, Builder> implements ConstructorOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            public Constructor build() {
                Constructor buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public Constructor buildPartial() {
                Constructor constructor = new Constructor((GeneratedMessageLite.ExtendableBuilder) this);
                int i = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                int unused = constructor.flags_ = this.flags_;
                if ((this.bitField0_ & 2) == 2) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= -3;
                }
                List unused2 = constructor.valueParameter_ = this.valueParameter_;
                if ((this.bitField0_ & 4) == 4) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -5;
                }
                List unused3 = constructor.versionRequirement_ = this.versionRequirement_;
                int unused4 = constructor.bitField0_ = i;
                return constructor;
            }

            public Builder mergeFrom(Constructor constructor) {
                if (constructor == Constructor.getDefaultInstance()) {
                    return this;
                }
                if (constructor.hasFlags()) {
                    setFlags(constructor.getFlags());
                }
                if (!constructor.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = constructor.valueParameter_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(constructor.valueParameter_);
                    }
                }
                if (!constructor.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = constructor.versionRequirement_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(constructor.versionRequirement_);
                    }
                }
                mergeExtensionFields(constructor);
                setUnknownFields(getUnknownFields().concat(constructor.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getValueParameterCount(); i++) {
                    if (!getValueParameter(i).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Constructor constructor;
                Constructor constructor2 = null;
                try {
                    Constructor parsePartialFrom = Constructor.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    constructor = (Constructor) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    constructor2 = constructor;
                }
                if (constructor2 != null) {
                    mergeFrom(constructor2);
                }
                throw th;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.valueParameter_ = new ArrayList(this.valueParameter_);
                    this.bitField0_ |= 2;
                }
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            public ValueParameter getValueParameter(int i) {
                return this.valueParameter_.get(i);
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4;
                }
            }
        }
    }

    public static final class Function extends GeneratedMessageLite.ExtendableMessage<Function> implements FunctionOrBuilder {
        public static Parser<Function> PARSER = new AbstractParser<Function>() {
            public Function parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Function(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Function defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> contextReceiverTypeId_;
        /* access modifiers changed from: private */
        public List<Type> contextReceiverType_;
        /* access modifiers changed from: private */
        public Contract contract_;
        /* access modifiers changed from: private */
        public int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public int oldFlags_;
        /* access modifiers changed from: private */
        public int receiverTypeId_;
        /* access modifiers changed from: private */
        public Type receiverType_;
        /* access modifiers changed from: private */
        public int returnTypeId_;
        /* access modifiers changed from: private */
        public Type returnType_;
        /* access modifiers changed from: private */
        public List<TypeParameter> typeParameter_;
        /* access modifiers changed from: private */
        public TypeTable typeTable_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public List<ValueParameter> valueParameter_;
        /* access modifiers changed from: private */
        public List<Integer> versionRequirement_;

        private Function(GeneratedMessageLite.ExtendableBuilder<Function, ?> extendableBuilder) {
            super(extendableBuilder);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Function(boolean z) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        public Function getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$Builder} */
        /* JADX WARNING: type inference failed for: r11v0 */
        /* JADX WARNING: type inference failed for: r11v29 */
        /* JADX WARNING: type inference failed for: r11v30 */
        /* JADX WARNING: type inference failed for: r11v31 */
        /* JADX WARNING: type inference failed for: r11v32 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Function(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r14, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r15) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r13 = this;
                r13.<init>()
                r0 = -1
                r13.contextReceiverTypeIdMemoizedSerializedSize = r0
                r13.memoizedIsInitialized = r0
                r13.memoizedSerializedSize = r0
                r13.initFields()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r1 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r0, r1)
                r3 = 0
                r4 = r3
            L_0x0018:
                r5 = 1024(0x400, float:1.435E-42)
                r6 = 4096(0x1000, float:5.74E-42)
                r7 = 512(0x200, float:7.175E-43)
                r8 = 256(0x100, float:3.59E-43)
                r9 = 32
                if (r3 != 0) goto L_0x0272
                int r10 = r14.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11 = 0
                switch(r10) {
                    case 0: goto L_0x0203;
                    case 8: goto L_0x01f5;
                    case 16: goto L_0x01e7;
                    case 26: goto L_0x01be;
                    case 34: goto L_0x01a4;
                    case 42: goto L_0x017d;
                    case 50: goto L_0x0163;
                    case 56: goto L_0x0155;
                    case 64: goto L_0x0147;
                    case 72: goto L_0x013a;
                    case 82: goto L_0x0120;
                    case 88: goto L_0x0104;
                    case 90: goto L_0x00d0;
                    case 242: goto L_0x00a7;
                    case 248: goto L_0x008b;
                    case 250: goto L_0x0058;
                    case 258: goto L_0x0032;
                    default: goto L_0x002c;
                }     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x002c:
                boolean r5 = r13.parseUnknownField(r14, r2, r15, r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0206
            L_0x0032:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 & r8
                if (r10 != r8) goto L_0x003d
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r10 = r13.contract_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$Builder r11 = r10.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x003d:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r14.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r10 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract) r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.contract_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 == 0) goto L_0x0052
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract) r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r10 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.contract_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x0052:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | r8
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0058:
                int r10 = r14.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.pushLimit(r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11 = r4 & 4096(0x1000, float:5.74E-42)
                if (r11 == r6) goto L_0x0073
                int r11 = r14.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 <= 0) goto L_0x0073
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.versionRequirement_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 4096(0x1000, float:5.74E-42)
            L_0x0073:
                int r11 = r14.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 <= 0) goto L_0x0087
                java.util.List<java.lang.Integer> r11 = r13.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r12 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0073
            L_0x0087:
                r14.popLimit(r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x008b:
                r10 = r4 & 4096(0x1000, float:5.74E-42)
                if (r10 == r6) goto L_0x0098
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.versionRequirement_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 4096(0x1000, float:5.74E-42)
            L_0x0098:
                java.util.List<java.lang.Integer> r10 = r13.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r11 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x00a7:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r12 = 128(0x80, float:1.794E-43)
                r10 = r10 & r12
                if (r10 != r12) goto L_0x00b4
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r10 = r13.typeTable_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder r11 = r10.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x00b4:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r14.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r10 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.typeTable_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 == 0) goto L_0x00c9
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r10 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.typeTable_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x00c9:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | r12
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x00d0:
                int r10 = r14.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.pushLimit(r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11 = r4 & 512(0x200, float:7.175E-43)
                if (r11 == r7) goto L_0x00eb
                int r11 = r14.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 <= 0) goto L_0x00eb
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.contextReceiverTypeId_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 512(0x200, float:7.175E-43)
            L_0x00eb:
                int r11 = r14.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 <= 0) goto L_0x00ff
                java.util.List<java.lang.Integer> r11 = r13.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r12 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x00eb
            L_0x00ff:
                r14.popLimit(r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0104:
                r10 = r4 & 512(0x200, float:7.175E-43)
                if (r10 == r7) goto L_0x0111
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.contextReceiverTypeId_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 512(0x200, float:7.175E-43)
            L_0x0111:
                java.util.List<java.lang.Integer> r10 = r13.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r11 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0120:
                r10 = r4 & 256(0x100, float:3.59E-43)
                if (r10 == r8) goto L_0x012d
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.contextReceiverType_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 256(0x100, float:3.59E-43)
            L_0x012d:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r10 = r13.contextReceiverType_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r14.readMessage(r11, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x013a:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | r1
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.flags_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0147:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | 64
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.receiverTypeId_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0155:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | 16
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.returnTypeId_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0163:
                r10 = r4 & 1024(0x400, float:1.435E-42)
                if (r10 == r5) goto L_0x0170
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.valueParameter_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 1024(0x400, float:1.435E-42)
            L_0x0170:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r10 = r13.valueParameter_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r14.readMessage(r11, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x017d:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 & r9
                if (r10 != r9) goto L_0x0188
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = r13.receiverType_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r11 = r10.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x0188:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r14.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.receiverType_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 == 0) goto L_0x019d
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.receiverType_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x019d:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | r9
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x01a4:
                r10 = r4 & 32
                if (r10 == r9) goto L_0x01b1
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.typeParameter_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 32
            L_0x01b1:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r10 = r13.typeParameter_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r14.readMessage(r11, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x01be:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r12 = 8
                r10 = r10 & r12
                if (r10 != r12) goto L_0x01cb
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = r13.returnType_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r11 = r10.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x01cb:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r14.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.returnType_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 == 0) goto L_0x01e0
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.returnType_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x01e0:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | r12
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x01e7:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | 4
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.name_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x01f5:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | 2
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.oldFlags_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0203:
                r3 = r1
                goto L_0x0018
            L_0x0206:
                if (r5 != 0) goto L_0x0018
                goto L_0x0203
            L_0x0209:
                r14 = move-exception
                goto L_0x0220
            L_0x020b:
                r14 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r15 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0209 }
                java.lang.String r14 = r14.getMessage()     // Catch:{ all -> 0x0209 }
                r15.<init>(r14)     // Catch:{ all -> 0x0209 }
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r14 = r15.setUnfinishedMessage(r13)     // Catch:{ all -> 0x0209 }
                throw r14     // Catch:{ all -> 0x0209 }
            L_0x021a:
                r14 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r14 = r14.setUnfinishedMessage(r13)     // Catch:{ all -> 0x0209 }
                throw r14     // Catch:{ all -> 0x0209 }
            L_0x0220:
                r15 = r4 & 32
                if (r15 != r9) goto L_0x022c
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r15 = r13.typeParameter_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.typeParameter_ = r15
            L_0x022c:
                r15 = r4 & 1024(0x400, float:1.435E-42)
                if (r15 != r5) goto L_0x0238
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r15 = r13.valueParameter_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.valueParameter_ = r15
            L_0x0238:
                r15 = r4 & 256(0x100, float:3.59E-43)
                if (r15 != r8) goto L_0x0244
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r15 = r13.contextReceiverType_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.contextReceiverType_ = r15
            L_0x0244:
                r15 = r4 & 512(0x200, float:7.175E-43)
                if (r15 != r7) goto L_0x0250
                java.util.List<java.lang.Integer> r15 = r13.contextReceiverTypeId_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.contextReceiverTypeId_ = r15
            L_0x0250:
                r15 = r4 & 4096(0x1000, float:5.74E-42)
                if (r15 != r6) goto L_0x025c
                java.util.List<java.lang.Integer> r15 = r13.versionRequirement_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.versionRequirement_ = r15
            L_0x025c:
                r2.flush()     // Catch:{ IOException -> 0x025f, all -> 0x0266 }
            L_0x025f:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r15 = r0.toByteString()
                r13.unknownFields = r15
                goto L_0x026e
            L_0x0266:
                r14 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r15 = r0.toByteString()
                r13.unknownFields = r15
                throw r14
            L_0x026e:
                r13.makeExtensionsImmutable()
                throw r14
            L_0x0272:
                r14 = r4 & 32
                if (r14 != r9) goto L_0x027e
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r14 = r13.typeParameter_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.typeParameter_ = r14
            L_0x027e:
                r14 = r4 & 1024(0x400, float:1.435E-42)
                if (r14 != r5) goto L_0x028a
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r14 = r13.valueParameter_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.valueParameter_ = r14
            L_0x028a:
                r14 = r4 & 256(0x100, float:3.59E-43)
                if (r14 != r8) goto L_0x0296
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r14 = r13.contextReceiverType_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.contextReceiverType_ = r14
            L_0x0296:
                r14 = r4 & 512(0x200, float:7.175E-43)
                if (r14 != r7) goto L_0x02a2
                java.util.List<java.lang.Integer> r14 = r13.contextReceiverTypeId_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.contextReceiverTypeId_ = r14
            L_0x02a2:
                r14 = r4 & 4096(0x1000, float:5.74E-42)
                if (r14 != r6) goto L_0x02ae
                java.util.List<java.lang.Integer> r14 = r13.versionRequirement_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.versionRequirement_ = r14
            L_0x02ae:
                r2.flush()     // Catch:{ IOException -> 0x02b1, all -> 0x02b8 }
            L_0x02b1:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r14 = r0.toByteString()
                r13.unknownFields = r14
                goto L_0x02c0
            L_0x02b8:
                r14 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r15 = r0.toByteString()
                r13.unknownFields = r15
                throw r14
            L_0x02c0:
                r13.makeExtensionsImmutable()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            Function function = new Function(true);
            defaultInstance = function;
            function.initFields();
        }

        public Parser<Function> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int i) {
            return this.typeParameter_.get(i);
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public Type getContextReceiverType(int i) {
            return this.contextReceiverType_.get(i);
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public ValueParameter getValueParameter(int i) {
            return this.valueParameter_.get(i);
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 128) == 128;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasContract() {
            return (this.bitField0_ & 256) == 256;
        }

        public Contract getContract() {
            return this.contract_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = Contract.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasReturnType() || getReturnType().isInitialized()) {
                for (int i = 0; i < getTypeParameterCount(); i++) {
                    if (!getTypeParameter(i).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!hasReceiverType() || getReceiverType().isInitialized()) {
                    for (int i2 = 0; i2 < getContextReceiverTypeCount(); i2++) {
                        if (!getContextReceiverType(i2).isInitialized()) {
                            this.memoizedIsInitialized = 0;
                            return false;
                        }
                    }
                    for (int i3 = 0; i3 < getValueParameterCount(); i3++) {
                        if (!getValueParameter(i3).isInitialized()) {
                            this.memoizedIsInitialized = 0;
                            return false;
                        }
                    }
                    if (hasTypeTable() && !getTypeTable().isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    } else if (hasContract() && !getContract().isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    } else if (!extensionsAreInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    } else {
                        this.memoizedIsInitialized = 1;
                        return true;
                    }
                } else {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(3, this.returnType_);
            }
            for (int i = 0; i < this.typeParameter_.size(); i++) {
                codedOutputStream.writeMessage(4, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(5, this.receiverType_);
            }
            for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
                codedOutputStream.writeMessage(6, this.valueParameter_.get(i2));
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(9, this.flags_);
            }
            for (int i3 = 0; i3 < this.contextReceiverType_.size(); i3++) {
                codedOutputStream.writeMessage(10, this.contextReceiverType_.get(i3));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(90);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.contextReceiverTypeId_.size(); i4++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i4).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i5).intValue());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeMessage(32, this.contract_);
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.oldFlags_) : 0;
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            for (int i3 = 0; i3 < this.valueParameter_.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(i3));
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, this.flags_);
            }
            for (int i4 = 0; i4 < this.contextReceiverType_.size(); i4++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(10, this.contextReceiverType_.get(i4));
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.contextReceiverTypeId_.size(); i6++) {
                i5 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i6).intValue());
            }
            int i7 = computeInt32Size + i5;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i7 = i7 + 1 + CodedOutputStream.computeInt32SizeNoTag(i5);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i5;
            if ((this.bitField0_ & 128) == 128) {
                i7 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.versionRequirement_.size(); i9++) {
                i8 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i9).intValue());
            }
            int size = i7 + i8 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 256) == 256) {
                size += CodedOutputStream.computeMessageSize(32, this.contract_);
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static Function parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Function function) {
            return newBuilder().mergeFrom(function);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Function, Builder> implements FunctionOrBuilder {
            private int bitField0_;
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private Contract contract_ = Contract.getDefaultInstance();
            private int flags_ = 6;
            private int name_;
            private int oldFlags_ = 6;
            private int receiverTypeId_;
            private Type receiverType_ = Type.getDefaultInstance();
            private int returnTypeId_;
            private Type returnType_ = Type.getDefaultInstance();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }

            public Function build() {
                Function buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public Function buildPartial() {
                Function function = new Function((GeneratedMessageLite.ExtendableBuilder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                int unused = function.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = function.oldFlags_ = this.oldFlags_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                int unused3 = function.name_ = this.name_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                Type unused4 = function.returnType_ = this.returnType_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                int unused5 = function.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -33;
                }
                List unused6 = function.typeParameter_ = this.typeParameter_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                Type unused7 = function.receiverType_ = this.receiverType_;
                if ((i & 128) == 128) {
                    i2 |= 64;
                }
                int unused8 = function.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -257;
                }
                List unused9 = function.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -513;
                }
                List unused10 = function.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= -1025;
                }
                List unused11 = function.valueParameter_ = this.valueParameter_;
                if ((i & 2048) == 2048) {
                    i2 |= 128;
                }
                TypeTable unused12 = function.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 4096) == 4096) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -4097;
                }
                List unused13 = function.versionRequirement_ = this.versionRequirement_;
                if ((i & 8192) == 8192) {
                    i2 |= 256;
                }
                Contract unused14 = function.contract_ = this.contract_;
                int unused15 = function.bitField0_ = i2;
                return function;
            }

            public Builder mergeFrom(Function function) {
                if (function == Function.getDefaultInstance()) {
                    return this;
                }
                if (function.hasFlags()) {
                    setFlags(function.getFlags());
                }
                if (function.hasOldFlags()) {
                    setOldFlags(function.getOldFlags());
                }
                if (function.hasName()) {
                    setName(function.getName());
                }
                if (function.hasReturnType()) {
                    mergeReturnType(function.getReturnType());
                }
                if (function.hasReturnTypeId()) {
                    setReturnTypeId(function.getReturnTypeId());
                }
                if (!function.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = function.typeParameter_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(function.typeParameter_);
                    }
                }
                if (function.hasReceiverType()) {
                    mergeReceiverType(function.getReceiverType());
                }
                if (function.hasReceiverTypeId()) {
                    setReceiverTypeId(function.getReceiverTypeId());
                }
                if (!function.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = function.contextReceiverType_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(function.contextReceiverType_);
                    }
                }
                if (!function.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = function.contextReceiverTypeId_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(function.contextReceiverTypeId_);
                    }
                }
                if (!function.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = function.valueParameter_;
                        this.bitField0_ &= -1025;
                    } else {
                        ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(function.valueParameter_);
                    }
                }
                if (function.hasTypeTable()) {
                    mergeTypeTable(function.getTypeTable());
                }
                if (!function.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = function.versionRequirement_;
                        this.bitField0_ &= -4097;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(function.versionRequirement_);
                    }
                }
                if (function.hasContract()) {
                    mergeContract(function.getContract());
                }
                mergeExtensionFields(function);
                setUnknownFields(getUnknownFields().concat(function.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasReturnType() && !getReturnType().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < getTypeParameterCount(); i++) {
                    if (!getTypeParameter(i).isInitialized()) {
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    return false;
                }
                for (int i2 = 0; i2 < getContextReceiverTypeCount(); i2++) {
                    if (!getContextReceiverType(i2).isInitialized()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < getValueParameterCount(); i3++) {
                    if (!getValueParameter(i3).isInitialized()) {
                        return false;
                    }
                }
                if (hasTypeTable() && !getTypeTable().isInitialized()) {
                    return false;
                }
                if ((!hasContract() || getContract().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Function function;
                Function function2 = null;
                try {
                    Function parsePartialFrom = Function.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    function = (Function) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    function2 = function;
                }
                if (function2 != null) {
                    mergeFrom(function2);
                }
                throw th;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public Builder setOldFlags(int i) {
                this.bitField0_ |= 2;
                this.oldFlags_ = i;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 4;
                this.name_ = i;
                return this;
            }

            public boolean hasReturnType() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public Builder mergeReturnType(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.returnType_ == Type.getDefaultInstance()) {
                    this.returnType_ = type;
                } else {
                    this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setReturnTypeId(int i) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = i;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 32;
                }
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int i) {
                return this.typeParameter_.get(i);
            }

            public boolean hasReceiverType() {
                return (this.bitField0_ & 64) == 64;
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Builder mergeReceiverType(Type type) {
                if ((this.bitField0_ & 64) != 64 || this.receiverType_ == Type.getDefaultInstance()) {
                    this.receiverType_ = type;
                } else {
                    this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setReceiverTypeId(int i) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i;
                return this;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 256;
                }
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Type getContextReceiverType(int i) {
                return this.contextReceiverType_.get(i);
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 512;
                }
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.valueParameter_ = new ArrayList(this.valueParameter_);
                    this.bitField0_ |= 1024;
                }
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            public ValueParameter getValueParameter(int i) {
                return this.valueParameter_.get(i);
            }

            public boolean hasTypeTable() {
                return (this.bitField0_ & 2048) == 2048;
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 2048) != 2048 || this.typeTable_ == TypeTable.getDefaultInstance()) {
                    this.typeTable_ = typeTable;
                } else {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                }
                this.bitField0_ |= 2048;
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4096) != 4096) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4096;
                }
            }

            public boolean hasContract() {
                return (this.bitField0_ & 8192) == 8192;
            }

            public Contract getContract() {
                return this.contract_;
            }

            public Builder mergeContract(Contract contract) {
                if ((this.bitField0_ & 8192) != 8192 || this.contract_ == Contract.getDefaultInstance()) {
                    this.contract_ = contract;
                } else {
                    this.contract_ = Contract.newBuilder(this.contract_).mergeFrom(contract).buildPartial();
                }
                this.bitField0_ |= 8192;
                return this;
            }
        }
    }

    public static final class Property extends GeneratedMessageLite.ExtendableMessage<Property> implements PropertyOrBuilder {
        public static Parser<Property> PARSER = new AbstractParser<Property>() {
            public Property parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Property(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Property defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> contextReceiverTypeId_;
        /* access modifiers changed from: private */
        public List<Type> contextReceiverType_;
        /* access modifiers changed from: private */
        public int flags_;
        /* access modifiers changed from: private */
        public int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public int oldFlags_;
        /* access modifiers changed from: private */
        public int receiverTypeId_;
        /* access modifiers changed from: private */
        public Type receiverType_;
        /* access modifiers changed from: private */
        public int returnTypeId_;
        /* access modifiers changed from: private */
        public Type returnType_;
        /* access modifiers changed from: private */
        public int setterFlags_;
        /* access modifiers changed from: private */
        public ValueParameter setterValueParameter_;
        /* access modifiers changed from: private */
        public List<TypeParameter> typeParameter_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public List<Integer> versionRequirement_;

        private Property(GeneratedMessageLite.ExtendableBuilder<Property, ?> extendableBuilder) {
            super(extendableBuilder);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Property(boolean z) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        public Property getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$Builder} */
        /* JADX WARNING: type inference failed for: r10v0 */
        /* JADX WARNING: type inference failed for: r10v25 */
        /* JADX WARNING: type inference failed for: r10v26 */
        /* JADX WARNING: type inference failed for: r10v27 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Property(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r13, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r14) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r12 = this;
                r12.<init>()
                r0 = -1
                r12.contextReceiverTypeIdMemoizedSerializedSize = r0
                r12.memoizedIsInitialized = r0
                r12.memoizedSerializedSize = r0
                r12.initFields()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r1 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r0, r1)
                r3 = 0
                r4 = r3
            L_0x0018:
                r5 = 256(0x100, float:3.59E-43)
                r6 = 8192(0x2000, float:1.14794E-41)
                r7 = 32
                r8 = 512(0x200, float:7.175E-43)
                if (r3 != 0) goto L_0x023d
                int r9 = r13.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10 = 0
                switch(r9) {
                    case 0: goto L_0x01da;
                    case 8: goto L_0x01cc;
                    case 16: goto L_0x01be;
                    case 26: goto L_0x0195;
                    case 34: goto L_0x017b;
                    case 42: goto L_0x0154;
                    case 50: goto L_0x012b;
                    case 56: goto L_0x011e;
                    case 64: goto L_0x0111;
                    case 72: goto L_0x0103;
                    case 80: goto L_0x00f5;
                    case 88: goto L_0x00e8;
                    case 98: goto L_0x00ce;
                    case 104: goto L_0x00b2;
                    case 106: goto L_0x007e;
                    case 248: goto L_0x0063;
                    case 250: goto L_0x0030;
                    default: goto L_0x002a;
                }     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x002a:
                boolean r5 = r12.parseUnknownField(r13, r2, r14, r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x01dd
            L_0x0030:
                int r9 = r13.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.pushLimit(r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10 = r4 & 8192(0x2000, float:1.14794E-41)
                if (r10 == r6) goto L_0x004b
                int r10 = r13.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 <= 0) goto L_0x004b
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.versionRequirement_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 8192(0x2000, float:1.14794E-41)
            L_0x004b:
                int r10 = r13.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 <= 0) goto L_0x005f
                java.util.List<java.lang.Integer> r10 = r12.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r11 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x004b
            L_0x005f:
                r13.popLimit(r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x0063:
                r9 = r4 & 8192(0x2000, float:1.14794E-41)
                if (r9 == r6) goto L_0x0070
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.versionRequirement_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 8192(0x2000, float:1.14794E-41)
            L_0x0070:
                java.util.List<java.lang.Integer> r9 = r12.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r10 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.add(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x007e:
                int r9 = r13.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.pushLimit(r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10 = r4 & 512(0x200, float:7.175E-43)
                if (r10 == r8) goto L_0x0099
                int r10 = r13.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 <= 0) goto L_0x0099
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.contextReceiverTypeId_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 512(0x200, float:7.175E-43)
            L_0x0099:
                int r10 = r13.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 <= 0) goto L_0x00ad
                java.util.List<java.lang.Integer> r10 = r12.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r11 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0099
            L_0x00ad:
                r13.popLimit(r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x00b2:
                r9 = r4 & 512(0x200, float:7.175E-43)
                if (r9 == r8) goto L_0x00bf
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.contextReceiverTypeId_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 512(0x200, float:7.175E-43)
            L_0x00bf:
                java.util.List<java.lang.Integer> r9 = r12.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r10 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.add(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x00ce:
                r9 = r4 & 256(0x100, float:3.59E-43)
                if (r9 == r5) goto L_0x00db
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.contextReceiverType_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 256(0x100, float:3.59E-43)
            L_0x00db:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r9 = r12.contextReceiverType_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r13.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r14)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.add(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x00e8:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r1
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.flags_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x00f5:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | 64
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.receiverTypeId_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x0103:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | 16
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.returnTypeId_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x0111:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r8
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.setterFlags_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x011e:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r5
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.getterFlags_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x012b:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r11 = 128(0x80, float:1.794E-43)
                r9 = r9 & r11
                if (r9 != r11) goto L_0x0138
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r9 = r12.setterValueParameter_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$Builder r10 = r9.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x0138:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r9 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r9 = r13.readMessage(r9, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r14)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r9 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.setterValueParameter_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 == 0) goto L_0x014d
                r10.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r9 = r10.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.setterValueParameter_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x014d:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r11
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x0154:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 & r7
                if (r9 != r7) goto L_0x015f
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = r12.receiverType_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r10 = r9.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x015f:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r9 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r9 = r13.readMessage(r9, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r14)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.receiverType_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 == 0) goto L_0x0174
                r10.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = r10.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.receiverType_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x0174:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r7
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x017b:
                r9 = r4 & 32
                if (r9 == r7) goto L_0x0188
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.typeParameter_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 32
            L_0x0188:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r9 = r12.typeParameter_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r13.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r14)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.add(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x0195:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r11 = 8
                r9 = r9 & r11
                if (r9 != r11) goto L_0x01a2
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = r12.returnType_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r10 = r9.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x01a2:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r9 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r9 = r13.readMessage(r9, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r14)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.returnType_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 == 0) goto L_0x01b7
                r10.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = r10.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.returnType_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x01b7:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r11
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x01be:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | 4
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.name_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x01cc:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | 2
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.oldFlags_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x01da:
                r3 = r1
                goto L_0x0018
            L_0x01dd:
                if (r5 != 0) goto L_0x0018
                goto L_0x01da
            L_0x01e0:
                r13 = move-exception
                goto L_0x01f7
            L_0x01e2:
                r13 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r14 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x01e0 }
                java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x01e0 }
                r14.<init>(r13)     // Catch:{ all -> 0x01e0 }
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r13 = r14.setUnfinishedMessage(r12)     // Catch:{ all -> 0x01e0 }
                throw r13     // Catch:{ all -> 0x01e0 }
            L_0x01f1:
                r13 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r13 = r13.setUnfinishedMessage(r12)     // Catch:{ all -> 0x01e0 }
                throw r13     // Catch:{ all -> 0x01e0 }
            L_0x01f7:
                r14 = r4 & 32
                if (r14 != r7) goto L_0x0203
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r14 = r12.typeParameter_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r12.typeParameter_ = r14
            L_0x0203:
                r14 = r4 & 256(0x100, float:3.59E-43)
                if (r14 != r5) goto L_0x020f
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r14 = r12.contextReceiverType_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r12.contextReceiverType_ = r14
            L_0x020f:
                r14 = r4 & 512(0x200, float:7.175E-43)
                if (r14 != r8) goto L_0x021b
                java.util.List<java.lang.Integer> r14 = r12.contextReceiverTypeId_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r12.contextReceiverTypeId_ = r14
            L_0x021b:
                r14 = r4 & 8192(0x2000, float:1.14794E-41)
                if (r14 != r6) goto L_0x0227
                java.util.List<java.lang.Integer> r14 = r12.versionRequirement_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r12.versionRequirement_ = r14
            L_0x0227:
                r2.flush()     // Catch:{ IOException -> 0x022a, all -> 0x0231 }
            L_0x022a:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r14 = r0.toByteString()
                r12.unknownFields = r14
                goto L_0x0239
            L_0x0231:
                r13 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r14 = r0.toByteString()
                r12.unknownFields = r14
                throw r13
            L_0x0239:
                r12.makeExtensionsImmutable()
                throw r13
            L_0x023d:
                r13 = r4 & 32
                if (r13 != r7) goto L_0x0249
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r13 = r12.typeParameter_
                java.util.List r13 = java.util.Collections.unmodifiableList(r13)
                r12.typeParameter_ = r13
            L_0x0249:
                r13 = r4 & 256(0x100, float:3.59E-43)
                if (r13 != r5) goto L_0x0255
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r13 = r12.contextReceiverType_
                java.util.List r13 = java.util.Collections.unmodifiableList(r13)
                r12.contextReceiverType_ = r13
            L_0x0255:
                r13 = r4 & 512(0x200, float:7.175E-43)
                if (r13 != r8) goto L_0x0261
                java.util.List<java.lang.Integer> r13 = r12.contextReceiverTypeId_
                java.util.List r13 = java.util.Collections.unmodifiableList(r13)
                r12.contextReceiverTypeId_ = r13
            L_0x0261:
                r13 = r4 & 8192(0x2000, float:1.14794E-41)
                if (r13 != r6) goto L_0x026d
                java.util.List<java.lang.Integer> r13 = r12.versionRequirement_
                java.util.List r13 = java.util.Collections.unmodifiableList(r13)
                r12.versionRequirement_ = r13
            L_0x026d:
                r2.flush()     // Catch:{ IOException -> 0x0270, all -> 0x0277 }
            L_0x0270:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r13 = r0.toByteString()
                r12.unknownFields = r13
                goto L_0x027f
            L_0x0277:
                r13 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r14 = r0.toByteString()
                r12.unknownFields = r14
                throw r13
            L_0x027f:
                r12.makeExtensionsImmutable()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            Property property = new Property(true);
            defaultInstance = property;
            property.initFields();
        }

        public Parser<Property> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int i) {
            return this.typeParameter_.get(i);
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public Type getContextReceiverType(int i) {
            return this.contextReceiverType_.get(i);
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public boolean hasSetterValueParameter() {
            return (this.bitField0_ & 128) == 128;
        }

        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public boolean hasGetterFlags() {
            return (this.bitField0_ & 256) == 256;
        }

        public int getGetterFlags() {
            return this.getterFlags_;
        }

        public boolean hasSetterFlags() {
            return (this.bitField0_ & 512) == 512;
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        private void initFields() {
            this.flags_ = 518;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasReturnType() || getReturnType().isInitialized()) {
                for (int i = 0; i < getTypeParameterCount(); i++) {
                    if (!getTypeParameter(i).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!hasReceiverType() || getReceiverType().isInitialized()) {
                    for (int i2 = 0; i2 < getContextReceiverTypeCount(); i2++) {
                        if (!getContextReceiverType(i2).isInitialized()) {
                            this.memoizedIsInitialized = 0;
                            return false;
                        }
                    }
                    if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    } else if (!extensionsAreInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    } else {
                        this.memoizedIsInitialized = 1;
                        return true;
                    }
                } else {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(3, this.returnType_);
            }
            for (int i = 0; i < this.typeParameter_.size(); i++) {
                codedOutputStream.writeMessage(4, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(11, this.flags_);
            }
            for (int i2 = 0; i2 < this.contextReceiverType_.size(); i2++) {
                codedOutputStream.writeMessage(12, this.contextReceiverType_.get(i2));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(106);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.contextReceiverTypeId_.size(); i3++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i3).intValue());
            }
            for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i4).intValue());
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.oldFlags_) : 0;
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeInt32Size += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                computeInt32Size += CodedOutputStream.computeInt32Size(11, this.flags_);
            }
            for (int i3 = 0; i3 < this.contextReceiverType_.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(12, this.contextReceiverType_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.contextReceiverTypeId_.size(); i5++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i5).intValue());
            }
            int i6 = computeInt32Size + i4;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.computeInt32SizeNoTag(i4);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i4;
            int i7 = 0;
            for (int i8 = 0; i8 < this.versionRequirement_.size(); i8++) {
                i7 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i8).intValue());
            }
            int size = i6 + i7 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Property property) {
            return newBuilder().mergeFrom(property);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Property, Builder> implements PropertyOrBuilder {
            private int bitField0_;
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private int flags_ = 518;
            private int getterFlags_;
            private int name_;
            private int oldFlags_ = 2054;
            private int receiverTypeId_;
            private Type receiverType_ = Type.getDefaultInstance();
            private int returnTypeId_;
            private Type returnType_ = Type.getDefaultInstance();
            private int setterFlags_;
            private ValueParameter setterValueParameter_ = ValueParameter.getDefaultInstance();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            public Property build() {
                Property buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public Property buildPartial() {
                Property property = new Property((GeneratedMessageLite.ExtendableBuilder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                int unused = property.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = property.oldFlags_ = this.oldFlags_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                int unused3 = property.name_ = this.name_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                Type unused4 = property.returnType_ = this.returnType_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                int unused5 = property.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -33;
                }
                List unused6 = property.typeParameter_ = this.typeParameter_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                Type unused7 = property.receiverType_ = this.receiverType_;
                if ((i & 128) == 128) {
                    i2 |= 64;
                }
                int unused8 = property.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -257;
                }
                List unused9 = property.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -513;
                }
                List unused10 = property.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((i & 1024) == 1024) {
                    i2 |= 128;
                }
                ValueParameter unused11 = property.setterValueParameter_ = this.setterValueParameter_;
                if ((i & 2048) == 2048) {
                    i2 |= 256;
                }
                int unused12 = property.getterFlags_ = this.getterFlags_;
                if ((i & 4096) == 4096) {
                    i2 |= 512;
                }
                int unused13 = property.setterFlags_ = this.setterFlags_;
                if ((this.bitField0_ & 8192) == 8192) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -8193;
                }
                List unused14 = property.versionRequirement_ = this.versionRequirement_;
                int unused15 = property.bitField0_ = i2;
                return property;
            }

            public Builder mergeFrom(Property property) {
                if (property == Property.getDefaultInstance()) {
                    return this;
                }
                if (property.hasFlags()) {
                    setFlags(property.getFlags());
                }
                if (property.hasOldFlags()) {
                    setOldFlags(property.getOldFlags());
                }
                if (property.hasName()) {
                    setName(property.getName());
                }
                if (property.hasReturnType()) {
                    mergeReturnType(property.getReturnType());
                }
                if (property.hasReturnTypeId()) {
                    setReturnTypeId(property.getReturnTypeId());
                }
                if (!property.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = property.typeParameter_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(property.typeParameter_);
                    }
                }
                if (property.hasReceiverType()) {
                    mergeReceiverType(property.getReceiverType());
                }
                if (property.hasReceiverTypeId()) {
                    setReceiverTypeId(property.getReceiverTypeId());
                }
                if (!property.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = property.contextReceiverType_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(property.contextReceiverType_);
                    }
                }
                if (!property.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = property.contextReceiverTypeId_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(property.contextReceiverTypeId_);
                    }
                }
                if (property.hasSetterValueParameter()) {
                    mergeSetterValueParameter(property.getSetterValueParameter());
                }
                if (property.hasGetterFlags()) {
                    setGetterFlags(property.getGetterFlags());
                }
                if (property.hasSetterFlags()) {
                    setSetterFlags(property.getSetterFlags());
                }
                if (!property.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = property.versionRequirement_;
                        this.bitField0_ &= -8193;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(property.versionRequirement_);
                    }
                }
                mergeExtensionFields(property);
                setUnknownFields(getUnknownFields().concat(property.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasReturnType() && !getReturnType().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < getTypeParameterCount(); i++) {
                    if (!getTypeParameter(i).isInitialized()) {
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    return false;
                }
                for (int i2 = 0; i2 < getContextReceiverTypeCount(); i2++) {
                    if (!getContextReceiverType(i2).isInitialized()) {
                        return false;
                    }
                }
                if ((!hasSetterValueParameter() || getSetterValueParameter().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Property property;
                Property property2 = null;
                try {
                    Property parsePartialFrom = Property.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    property = (Property) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    property2 = property;
                }
                if (property2 != null) {
                    mergeFrom(property2);
                }
                throw th;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public Builder setOldFlags(int i) {
                this.bitField0_ |= 2;
                this.oldFlags_ = i;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 4;
                this.name_ = i;
                return this;
            }

            public boolean hasReturnType() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public Builder mergeReturnType(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.returnType_ == Type.getDefaultInstance()) {
                    this.returnType_ = type;
                } else {
                    this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setReturnTypeId(int i) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = i;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 32;
                }
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int i) {
                return this.typeParameter_.get(i);
            }

            public boolean hasReceiverType() {
                return (this.bitField0_ & 64) == 64;
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Builder mergeReceiverType(Type type) {
                if ((this.bitField0_ & 64) != 64 || this.receiverType_ == Type.getDefaultInstance()) {
                    this.receiverType_ = type;
                } else {
                    this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setReceiverTypeId(int i) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i;
                return this;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 256;
                }
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Type getContextReceiverType(int i) {
                return this.contextReceiverType_.get(i);
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 512;
                }
            }

            public boolean hasSetterValueParameter() {
                return (this.bitField0_ & 1024) == 1024;
            }

            public ValueParameter getSetterValueParameter() {
                return this.setterValueParameter_;
            }

            public Builder mergeSetterValueParameter(ValueParameter valueParameter) {
                if ((this.bitField0_ & 1024) != 1024 || this.setterValueParameter_ == ValueParameter.getDefaultInstance()) {
                    this.setterValueParameter_ = valueParameter;
                } else {
                    this.setterValueParameter_ = ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(valueParameter).buildPartial();
                }
                this.bitField0_ |= 1024;
                return this;
            }

            public Builder setGetterFlags(int i) {
                this.bitField0_ |= 2048;
                this.getterFlags_ = i;
                return this;
            }

            public Builder setSetterFlags(int i) {
                this.bitField0_ |= 4096;
                this.setterFlags_ = i;
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 8192) != 8192) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 8192;
                }
            }
        }
    }

    public static final class ValueParameter extends GeneratedMessageLite.ExtendableMessage<ValueParameter> implements ValueParameterOrBuilder {
        public static Parser<ValueParameter> PARSER = new AbstractParser<ValueParameter>() {
            public ValueParameter parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ValueParameter(codedInputStream, extensionRegistryLite);
            }
        };
        private static final ValueParameter defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public int typeId_;
        /* access modifiers changed from: private */
        public Type type_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public int varargElementTypeId_;
        /* access modifiers changed from: private */
        public Type varargElementType_;

        private ValueParameter(GeneratedMessageLite.ExtendableBuilder<ValueParameter, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private ValueParameter(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        public ValueParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        private ValueParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                        } else if (readTag != 16) {
                            Type.Builder builder = null;
                            if (readTag == 26) {
                                builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : builder;
                                Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                this.type_ = type;
                                if (builder != null) {
                                    builder.mergeFrom(type);
                                    this.type_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (readTag == 34) {
                                builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : builder;
                                Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                this.varargElementType_ = type2;
                                if (builder != null) {
                                    builder.mergeFrom(type2);
                                    this.varargElementType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 16;
                            } else if (readTag == 40) {
                                this.bitField0_ |= 8;
                                this.typeId_ = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.bitField0_ |= 32;
                                this.varargElementTypeId_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0_ |= 2;
                            this.name_ = codedInputStream.readInt32();
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            ValueParameter valueParameter = new ValueParameter(true);
            defaultInstance = valueParameter;
            valueParameter.initFields();
        }

        public Parser<ValueParameter> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        public Type getType() {
            return this.type_;
        }

        public boolean hasTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean hasVarargElementType() {
            return (this.bitField0_ & 16) == 16;
        }

        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        public boolean hasVarargElementTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        private void initFields() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (hasType() && !getType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.varargElementTypeId_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
            }
            int extensionsSerializedSize = computeInt32Size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ValueParameter valueParameter) {
            return newBuilder().mergeFrom(valueParameter);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ValueParameter, Builder> implements ValueParameterOrBuilder {
            private int bitField0_;
            private int flags_;
            private int name_;
            private int typeId_;
            private Type type_ = Type.getDefaultInstance();
            private int varargElementTypeId_;
            private Type varargElementType_ = Type.getDefaultInstance();

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            public ValueParameter build() {
                ValueParameter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public ValueParameter buildPartial() {
                ValueParameter valueParameter = new ValueParameter((GeneratedMessageLite.ExtendableBuilder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                int unused = valueParameter.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = valueParameter.name_ = this.name_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Type unused3 = valueParameter.type_ = this.type_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                int unused4 = valueParameter.typeId_ = this.typeId_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                Type unused5 = valueParameter.varargElementType_ = this.varargElementType_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                int unused6 = valueParameter.varargElementTypeId_ = this.varargElementTypeId_;
                int unused7 = valueParameter.bitField0_ = i2;
                return valueParameter;
            }

            public Builder mergeFrom(ValueParameter valueParameter) {
                if (valueParameter == ValueParameter.getDefaultInstance()) {
                    return this;
                }
                if (valueParameter.hasFlags()) {
                    setFlags(valueParameter.getFlags());
                }
                if (valueParameter.hasName()) {
                    setName(valueParameter.getName());
                }
                if (valueParameter.hasType()) {
                    mergeType(valueParameter.getType());
                }
                if (valueParameter.hasTypeId()) {
                    setTypeId(valueParameter.getTypeId());
                }
                if (valueParameter.hasVarargElementType()) {
                    mergeVarargElementType(valueParameter.getVarargElementType());
                }
                if (valueParameter.hasVarargElementTypeId()) {
                    setVarargElementTypeId(valueParameter.getVarargElementTypeId());
                }
                mergeExtensionFields(valueParameter);
                setUnknownFields(getUnknownFields().concat(valueParameter.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasType() && !getType().isInitialized()) {
                    return false;
                }
                if ((!hasVarargElementType() || getVarargElementType().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ValueParameter valueParameter;
                ValueParameter valueParameter2 = null;
                try {
                    ValueParameter parsePartialFrom = ValueParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    valueParameter = (ValueParameter) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    valueParameter2 = valueParameter;
                }
                if (valueParameter2 != null) {
                    mergeFrom(valueParameter2);
                }
                throw th;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 2;
                this.name_ = i;
                return this;
            }

            public boolean hasType() {
                return (this.bitField0_ & 4) == 4;
            }

            public Type getType() {
                return this.type_;
            }

            public Builder mergeType(Type type) {
                if ((this.bitField0_ & 4) != 4 || this.type_ == Type.getDefaultInstance()) {
                    this.type_ = type;
                } else {
                    this.type_ = Type.newBuilder(this.type_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setTypeId(int i) {
                this.bitField0_ |= 8;
                this.typeId_ = i;
                return this;
            }

            public boolean hasVarargElementType() {
                return (this.bitField0_ & 16) == 16;
            }

            public Type getVarargElementType() {
                return this.varargElementType_;
            }

            public Builder mergeVarargElementType(Type type) {
                if ((this.bitField0_ & 16) != 16 || this.varargElementType_ == Type.getDefaultInstance()) {
                    this.varargElementType_ = type;
                } else {
                    this.varargElementType_ = Type.newBuilder(this.varargElementType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setVarargElementTypeId(int i) {
                this.bitField0_ |= 32;
                this.varargElementTypeId_ = i;
                return this;
            }
        }
    }

    public static final class TypeAlias extends GeneratedMessageLite.ExtendableMessage<TypeAlias> implements TypeAliasOrBuilder {
        public static Parser<TypeAlias> PARSER = new AbstractParser<TypeAlias>() {
            public TypeAlias parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeAlias(codedInputStream, extensionRegistryLite);
            }
        };
        private static final TypeAlias defaultInstance;
        /* access modifiers changed from: private */
        public List<Annotation> annotation_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int expandedTypeId_;
        /* access modifiers changed from: private */
        public Type expandedType_;
        /* access modifiers changed from: private */
        public int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public List<TypeParameter> typeParameter_;
        /* access modifiers changed from: private */
        public int underlyingTypeId_;
        /* access modifiers changed from: private */
        public Type underlyingType_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public List<Integer> versionRequirement_;

        private TypeAlias(GeneratedMessageLite.ExtendableBuilder<TypeAlias, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private TypeAlias(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        public TypeAlias getDefaultInstanceForType() {
            return defaultInstance;
        }

        private TypeAlias(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    Type.Builder builder = null;
                    switch (readTag) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.name_ = codedInputStream.readInt32();
                            break;
                        case 26:
                            if (!(z2 & true)) {
                                this.typeParameter_ = new ArrayList();
                                z2 |= true;
                            }
                            this.typeParameter_.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                            break;
                        case 34:
                            builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : builder;
                            Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.underlyingType_ = type;
                            if (builder != null) {
                                builder.mergeFrom(type);
                                this.underlyingType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            break;
                        case 40:
                            this.bitField0_ |= 8;
                            this.underlyingTypeId_ = codedInputStream.readInt32();
                            break;
                        case 50:
                            builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : builder;
                            Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.expandedType_ = type2;
                            if (builder != null) {
                                builder.mergeFrom(type2);
                                this.expandedType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 16;
                            break;
                        case 56:
                            this.bitField0_ |= 32;
                            this.expandedTypeId_ = codedInputStream.readInt32();
                            break;
                        case 66:
                            if (!(z2 & true)) {
                                this.annotation_ = new ArrayList();
                                z2 |= true;
                            }
                            this.annotation_.add(codedInputStream.readMessage(Annotation.PARSER, extensionRegistryLite));
                            break;
                        case 248:
                            if (!(z2 & true)) {
                                this.versionRequirement_ = new ArrayList();
                                z2 |= true;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION:
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                            break;
                        default:
                            if (parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                break;
                            }
                            z = true;
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z2 & true) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if (z2 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if (z2 & true) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
            }
            if (z2 & true) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            TypeAlias typeAlias = new TypeAlias(true);
            defaultInstance = typeAlias;
            typeAlias.initFields();
        }

        public Parser<TypeAlias> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getName() {
            return this.name_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int i) {
            return this.typeParameter_.get(i);
        }

        public boolean hasUnderlyingType() {
            return (this.bitField0_ & 4) == 4;
        }

        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        public boolean hasUnderlyingTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        public boolean hasExpandedType() {
            return (this.bitField0_ & 16) == 16;
        }

        public Type getExpandedType() {
            return this.expandedType_;
        }

        public boolean hasExpandedTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public Annotation getAnnotation(int i) {
            return this.annotation_.get(i);
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getTypeParameterCount(); i++) {
                if (!getTypeParameter(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasExpandedType() || getExpandedType().isInitialized()) {
                for (int i2 = 0; i2 < getAnnotationCount(); i2++) {
                    if (!getAnnotation(i2).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            for (int i = 0; i < this.typeParameter_.size(); i++) {
                codedOutputStream.writeMessage(3, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(7, this.expandedTypeId_);
            }
            for (int i2 = 0; i2 < this.annotation_.size(); i2++) {
                codedOutputStream.writeMessage(8, this.annotation_.get(i2));
            }
            for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i3).intValue());
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
            }
            for (int i3 = 0; i3 < this.annotation_.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(8, this.annotation_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i5).intValue());
            }
            int size = computeInt32Size + i4 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static TypeAlias parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TypeAlias typeAlias) {
            return newBuilder().mergeFrom(typeAlias);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeAlias, Builder> implements TypeAliasOrBuilder {
            private List<Annotation> annotation_ = Collections.emptyList();
            private int bitField0_;
            private int expandedTypeId_;
            private Type expandedType_ = Type.getDefaultInstance();
            private int flags_ = 6;
            private int name_;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private int underlyingTypeId_;
            private Type underlyingType_ = Type.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            public TypeAlias build() {
                TypeAlias buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public TypeAlias buildPartial() {
                TypeAlias typeAlias = new TypeAlias((GeneratedMessageLite.ExtendableBuilder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                int unused = typeAlias.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = typeAlias.name_ = this.name_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -5;
                }
                List unused3 = typeAlias.typeParameter_ = this.typeParameter_;
                if ((i & 8) == 8) {
                    i2 |= 4;
                }
                Type unused4 = typeAlias.underlyingType_ = this.underlyingType_;
                if ((i & 16) == 16) {
                    i2 |= 8;
                }
                int unused5 = typeAlias.underlyingTypeId_ = this.underlyingTypeId_;
                if ((i & 32) == 32) {
                    i2 |= 16;
                }
                Type unused6 = typeAlias.expandedType_ = this.expandedType_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                int unused7 = typeAlias.expandedTypeId_ = this.expandedTypeId_;
                if ((this.bitField0_ & 128) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= -129;
                }
                List unused8 = typeAlias.annotation_ = this.annotation_;
                if ((this.bitField0_ & 256) == 256) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -257;
                }
                List unused9 = typeAlias.versionRequirement_ = this.versionRequirement_;
                int unused10 = typeAlias.bitField0_ = i2;
                return typeAlias;
            }

            public Builder mergeFrom(TypeAlias typeAlias) {
                if (typeAlias == TypeAlias.getDefaultInstance()) {
                    return this;
                }
                if (typeAlias.hasFlags()) {
                    setFlags(typeAlias.getFlags());
                }
                if (typeAlias.hasName()) {
                    setName(typeAlias.getName());
                }
                if (!typeAlias.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = typeAlias.typeParameter_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(typeAlias.typeParameter_);
                    }
                }
                if (typeAlias.hasUnderlyingType()) {
                    mergeUnderlyingType(typeAlias.getUnderlyingType());
                }
                if (typeAlias.hasUnderlyingTypeId()) {
                    setUnderlyingTypeId(typeAlias.getUnderlyingTypeId());
                }
                if (typeAlias.hasExpandedType()) {
                    mergeExpandedType(typeAlias.getExpandedType());
                }
                if (typeAlias.hasExpandedTypeId()) {
                    setExpandedTypeId(typeAlias.getExpandedTypeId());
                }
                if (!typeAlias.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = typeAlias.annotation_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureAnnotationIsMutable();
                        this.annotation_.addAll(typeAlias.annotation_);
                    }
                }
                if (!typeAlias.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = typeAlias.versionRequirement_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(typeAlias.versionRequirement_);
                    }
                }
                mergeExtensionFields(typeAlias);
                setUnknownFields(getUnknownFields().concat(typeAlias.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                for (int i = 0; i < getTypeParameterCount(); i++) {
                    if (!getTypeParameter(i).isInitialized()) {
                        return false;
                    }
                }
                if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                    return false;
                }
                if (hasExpandedType() && !getExpandedType().isInitialized()) {
                    return false;
                }
                for (int i2 = 0; i2 < getAnnotationCount(); i2++) {
                    if (!getAnnotation(i2).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeAlias typeAlias;
                TypeAlias typeAlias2 = null;
                try {
                    TypeAlias parsePartialFrom = TypeAlias.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    typeAlias = (TypeAlias) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    typeAlias2 = typeAlias;
                }
                if (typeAlias2 != null) {
                    mergeFrom(typeAlias2);
                }
                throw th;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 2;
                this.name_ = i;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 4;
                }
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int i) {
                return this.typeParameter_.get(i);
            }

            public boolean hasUnderlyingType() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type getUnderlyingType() {
                return this.underlyingType_;
            }

            public Builder mergeUnderlyingType(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.underlyingType_ == Type.getDefaultInstance()) {
                    this.underlyingType_ = type;
                } else {
                    this.underlyingType_ = Type.newBuilder(this.underlyingType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setUnderlyingTypeId(int i) {
                this.bitField0_ |= 16;
                this.underlyingTypeId_ = i;
                return this;
            }

            public boolean hasExpandedType() {
                return (this.bitField0_ & 32) == 32;
            }

            public Type getExpandedType() {
                return this.expandedType_;
            }

            public Builder mergeExpandedType(Type type) {
                if ((this.bitField0_ & 32) != 32 || this.expandedType_ == Type.getDefaultInstance()) {
                    this.expandedType_ = type;
                } else {
                    this.expandedType_ = Type.newBuilder(this.expandedType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setExpandedTypeId(int i) {
                this.bitField0_ |= 64;
                this.expandedTypeId_ = i;
                return this;
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 128) != 128) {
                    this.annotation_ = new ArrayList(this.annotation_);
                    this.bitField0_ |= 128;
                }
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public Annotation getAnnotation(int i) {
                return this.annotation_.get(i);
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 256;
                }
            }
        }
    }

    public static final class EnumEntry extends GeneratedMessageLite.ExtendableMessage<EnumEntry> implements EnumEntryOrBuilder {
        public static Parser<EnumEntry> PARSER = new AbstractParser<EnumEntry>() {
            public EnumEntry parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EnumEntry(codedInputStream, extensionRegistryLite);
            }
        };
        private static final EnumEntry defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        private EnumEntry(GeneratedMessageLite.ExtendableBuilder<EnumEntry, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private EnumEntry(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        public EnumEntry getDefaultInstanceForType() {
            return defaultInstance;
        }

        private EnumEntry(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.name_ = codedInputStream.readInt32();
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            EnumEntry enumEntry = new EnumEntry(true);
            defaultInstance = enumEntry;
            enumEntry.initFields();
        }

        public Parser<EnumEntry> getParserForType() {
            return PARSER;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getName() {
            return this.name_;
        }

        private void initFields() {
            this.name_ = 0;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = ((this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.name_) : 0) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = computeInt32Size;
            return computeInt32Size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumEntry enumEntry) {
            return newBuilder().mergeFrom(enumEntry);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumEntry, Builder> implements EnumEntryOrBuilder {
            private int bitField0_;
            private int name_;

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            public EnumEntry build() {
                EnumEntry buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public EnumEntry buildPartial() {
                EnumEntry enumEntry = new EnumEntry((GeneratedMessageLite.ExtendableBuilder) this);
                int i = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                int unused = enumEntry.name_ = this.name_;
                int unused2 = enumEntry.bitField0_ = i;
                return enumEntry;
            }

            public Builder mergeFrom(EnumEntry enumEntry) {
                if (enumEntry == EnumEntry.getDefaultInstance()) {
                    return this;
                }
                if (enumEntry.hasName()) {
                    setName(enumEntry.getName());
                }
                mergeExtensionFields(enumEntry);
                setUnknownFields(getUnknownFields().concat(enumEntry.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                return extensionsAreInitialized();
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                EnumEntry enumEntry;
                EnumEntry enumEntry2 = null;
                try {
                    EnumEntry parsePartialFrom = EnumEntry.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    enumEntry = (EnumEntry) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    enumEntry2 = enumEntry;
                }
                if (enumEntry2 != null) {
                    mergeFrom(enumEntry2);
                }
                throw th;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 1;
                this.name_ = i;
                return this;
            }
        }
    }

    public static final class VersionRequirement extends GeneratedMessageLite implements VersionRequirementOrBuilder {
        public static Parser<VersionRequirement> PARSER = new AbstractParser<VersionRequirement>() {
            public VersionRequirement parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VersionRequirement(codedInputStream, extensionRegistryLite);
            }
        };
        private static final VersionRequirement defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int errorCode_;
        /* access modifiers changed from: private */
        public Level level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int message_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public int versionFull_;
        /* access modifiers changed from: private */
        public VersionKind versionKind_;
        /* access modifiers changed from: private */
        public int version_;

        private VersionRequirement(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private VersionRequirement(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static VersionRequirement getDefaultInstance() {
            return defaultInstance;
        }

        public VersionRequirement getDefaultInstanceForType() {
            return defaultInstance;
        }

        private VersionRequirement(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.version_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.versionFull_ = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            int readEnum = codedInputStream.readEnum();
                            Level valueOf = Level.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 4;
                                this.level_ = valueOf;
                            }
                        } else if (readTag == 32) {
                            this.bitField0_ |= 8;
                            this.errorCode_ = codedInputStream.readInt32();
                        } else if (readTag == 40) {
                            this.bitField0_ |= 16;
                            this.message_ = codedInputStream.readInt32();
                        } else if (readTag == 48) {
                            int readEnum2 = codedInputStream.readEnum();
                            VersionKind valueOf2 = VersionKind.valueOf(readEnum2);
                            if (valueOf2 == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum2);
                            } else {
                                this.bitField0_ |= 32;
                                this.versionKind_ = valueOf2;
                            }
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            VersionRequirement versionRequirement = new VersionRequirement(true);
            defaultInstance = versionRequirement;
            versionRequirement.initFields();
        }

        public Parser<VersionRequirement> getParserForType() {
            return PARSER;
        }

        public enum Level implements Internal.EnumLite {
            WARNING(0, 0),
            ERROR(1, 1),
            HIDDEN(2, 2);
            
            private static Internal.EnumLiteMap<Level> internalValueMap;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<Level>() {
                    public Level findValueByNumber(int i) {
                        return Level.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int i) {
                if (i == 0) {
                    return WARNING;
                }
                if (i == 1) {
                    return ERROR;
                }
                if (i != 2) {
                    return null;
                }
                return HIDDEN;
            }

            private Level(int i, int i2) {
                this.value = i2;
            }
        }

        public enum VersionKind implements Internal.EnumLite {
            LANGUAGE_VERSION(0, 0),
            COMPILER_VERSION(1, 1),
            API_VERSION(2, 2);
            
            private static Internal.EnumLiteMap<VersionKind> internalValueMap;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<VersionKind>() {
                    public VersionKind findValueByNumber(int i) {
                        return VersionKind.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static VersionKind valueOf(int i) {
                if (i == 0) {
                    return LANGUAGE_VERSION;
                }
                if (i == 1) {
                    return COMPILER_VERSION;
                }
                if (i != 2) {
                    return null;
                }
                return API_VERSION;
            }

            private VersionKind(int i, int i2) {
                this.value = i2;
            }
        }

        public boolean hasVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getVersion() {
            return this.version_;
        }

        public boolean hasVersionFull() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getVersionFull() {
            return this.versionFull_;
        }

        public boolean hasLevel() {
            return (this.bitField0_ & 4) == 4;
        }

        public Level getLevel() {
            return this.level_;
        }

        public boolean hasErrorCode() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public boolean hasMessage() {
            return (this.bitField0_ & 16) == 16;
        }

        public int getMessage() {
            return this.message_;
        }

        public boolean hasVersionKind() {
            return (this.bitField0_ & 32) == 32;
        }

        public VersionKind getVersionKind() {
            return this.versionKind_;
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeEnum(6, this.versionKind_.getNumber());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.version_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeInt32Size(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
            }
            int size = computeInt32Size + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(VersionRequirement versionRequirement) {
            return newBuilder().mergeFrom(versionRequirement);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirement, Builder> implements VersionRequirementOrBuilder {
            private int bitField0_;
            private int errorCode_;
            private Level level_ = Level.ERROR;
            private int message_;
            private int versionFull_;
            private VersionKind versionKind_ = VersionKind.LANGUAGE_VERSION;
            private int version_;

            private void maybeForceBuilderInitialization() {
            }

            public final boolean isInitialized() {
                return true;
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
            }

            public VersionRequirement build() {
                VersionRequirement buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public VersionRequirement buildPartial() {
                VersionRequirement versionRequirement = new VersionRequirement((GeneratedMessageLite.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                int unused = versionRequirement.version_ = this.version_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = versionRequirement.versionFull_ = this.versionFull_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Level unused3 = versionRequirement.level_ = this.level_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                int unused4 = versionRequirement.errorCode_ = this.errorCode_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                int unused5 = versionRequirement.message_ = this.message_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                VersionKind unused6 = versionRequirement.versionKind_ = this.versionKind_;
                int unused7 = versionRequirement.bitField0_ = i2;
                return versionRequirement;
            }

            public Builder mergeFrom(VersionRequirement versionRequirement) {
                if (versionRequirement == VersionRequirement.getDefaultInstance()) {
                    return this;
                }
                if (versionRequirement.hasVersion()) {
                    setVersion(versionRequirement.getVersion());
                }
                if (versionRequirement.hasVersionFull()) {
                    setVersionFull(versionRequirement.getVersionFull());
                }
                if (versionRequirement.hasLevel()) {
                    setLevel(versionRequirement.getLevel());
                }
                if (versionRequirement.hasErrorCode()) {
                    setErrorCode(versionRequirement.getErrorCode());
                }
                if (versionRequirement.hasMessage()) {
                    setMessage(versionRequirement.getMessage());
                }
                if (versionRequirement.hasVersionKind()) {
                    setVersionKind(versionRequirement.getVersionKind());
                }
                setUnknownFields(getUnknownFields().concat(versionRequirement.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                VersionRequirement versionRequirement;
                VersionRequirement versionRequirement2 = null;
                try {
                    VersionRequirement parsePartialFrom = VersionRequirement.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    versionRequirement = (VersionRequirement) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    versionRequirement2 = versionRequirement;
                }
                if (versionRequirement2 != null) {
                    mergeFrom(versionRequirement2);
                }
                throw th;
            }

            public Builder setVersion(int i) {
                this.bitField0_ |= 1;
                this.version_ = i;
                return this;
            }

            public Builder setVersionFull(int i) {
                this.bitField0_ |= 2;
                this.versionFull_ = i;
                return this;
            }

            public Builder setLevel(Level level) {
                level.getClass();
                this.bitField0_ |= 4;
                this.level_ = level;
                return this;
            }

            public Builder setErrorCode(int i) {
                this.bitField0_ |= 8;
                this.errorCode_ = i;
                return this;
            }

            public Builder setMessage(int i) {
                this.bitField0_ |= 16;
                this.message_ = i;
                return this;
            }

            public Builder setVersionKind(VersionKind versionKind) {
                versionKind.getClass();
                this.bitField0_ |= 32;
                this.versionKind_ = versionKind;
                return this;
            }
        }
    }

    public static final class VersionRequirementTable extends GeneratedMessageLite implements VersionRequirementTableOrBuilder {
        public static Parser<VersionRequirementTable> PARSER = new AbstractParser<VersionRequirementTable>() {
            public VersionRequirementTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VersionRequirementTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final VersionRequirementTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<VersionRequirement> requirement_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        private VersionRequirementTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private VersionRequirementTable(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static VersionRequirementTable getDefaultInstance() {
            return defaultInstance;
        }

        public VersionRequirementTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        private VersionRequirementTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2) {
                                this.requirement_ = new ArrayList();
                                z2 = true;
                            }
                            this.requirement_.add(codedInputStream.readMessage(VersionRequirement.PARSER, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2) {
                        this.requirement_ = Collections.unmodifiableList(this.requirement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2) {
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            VersionRequirementTable versionRequirementTable = new VersionRequirementTable(true);
            defaultInstance = versionRequirementTable;
            versionRequirementTable.initFields();
        }

        public Parser<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        public List<VersionRequirement> getRequirementList() {
            return this.requirement_;
        }

        public int getRequirementCount() {
            return this.requirement_.size();
        }

        private void initFields() {
            this.requirement_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.requirement_.size(); i++) {
                codedOutputStream.writeMessage(1, this.requirement_.get(i));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.requirement_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.requirement_.get(i3));
            }
            int size = i2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(VersionRequirementTable versionRequirementTable) {
            return newBuilder().mergeFrom(versionRequirementTable);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirementTable, Builder> implements VersionRequirementTableOrBuilder {
            private int bitField0_;
            private List<VersionRequirement> requirement_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            public final boolean isInitialized() {
                return true;
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
            }

            public VersionRequirementTable build() {
                VersionRequirementTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public VersionRequirementTable buildPartial() {
                VersionRequirementTable versionRequirementTable = new VersionRequirementTable((GeneratedMessageLite.Builder) this);
                if ((this.bitField0_ & 1) == 1) {
                    this.requirement_ = Collections.unmodifiableList(this.requirement_);
                    this.bitField0_ &= -2;
                }
                List unused = versionRequirementTable.requirement_ = this.requirement_;
                return versionRequirementTable;
            }

            public Builder mergeFrom(VersionRequirementTable versionRequirementTable) {
                if (versionRequirementTable == VersionRequirementTable.getDefaultInstance()) {
                    return this;
                }
                if (!versionRequirementTable.requirement_.isEmpty()) {
                    if (this.requirement_.isEmpty()) {
                        this.requirement_ = versionRequirementTable.requirement_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRequirementIsMutable();
                        this.requirement_.addAll(versionRequirementTable.requirement_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(versionRequirementTable.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                VersionRequirementTable versionRequirementTable;
                VersionRequirementTable versionRequirementTable2 = null;
                try {
                    VersionRequirementTable parsePartialFrom = VersionRequirementTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    versionRequirementTable = (VersionRequirementTable) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    versionRequirementTable2 = versionRequirementTable;
                }
                if (versionRequirementTable2 != null) {
                    mergeFrom(versionRequirementTable2);
                }
                throw th;
            }

            private void ensureRequirementIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.requirement_ = new ArrayList(this.requirement_);
                    this.bitField0_ |= 1;
                }
            }
        }
    }

    public static final class PackageFragment extends GeneratedMessageLite.ExtendableMessage<PackageFragment> implements PackageFragmentOrBuilder {
        public static Parser<PackageFragment> PARSER = new AbstractParser<PackageFragment>() {
            public PackageFragment parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PackageFragment(codedInputStream, extensionRegistryLite);
            }
        };
        private static final PackageFragment defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public List<Class> class__;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Package package_;
        /* access modifiers changed from: private */
        public QualifiedNameTable qualifiedNames_;
        /* access modifiers changed from: private */
        public StringTable strings_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        private PackageFragment(GeneratedMessageLite.ExtendableBuilder<PackageFragment, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private PackageFragment(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static PackageFragment getDefaultInstance() {
            return defaultInstance;
        }

        public PackageFragment getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$Builder} */
        /* JADX WARNING: type inference failed for: r8v0 */
        /* JADX WARNING: type inference failed for: r8v7 */
        /* JADX WARNING: type inference failed for: r8v8 */
        /* JADX WARNING: type inference failed for: r8v9 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private PackageFragment(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r10, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r11) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r9 = this;
                r9.<init>()
                r0 = -1
                r9.memoizedIsInitialized = r0
                r9.memoizedSerializedSize = r0
                r9.initFields()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r1 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r0, r1)
                r3 = 0
                r4 = r3
            L_0x0016:
                r5 = 8
                if (r3 != 0) goto L_0x0103
                int r6 = r10.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                if (r6 == 0) goto L_0x00c7
                r7 = 10
                r8 = 0
                if (r6 == r7) goto L_0x00a0
                r7 = 18
                if (r6 == r7) goto L_0x0078
                r7 = 26
                if (r6 == r7) goto L_0x0051
                r7 = 34
                if (r6 == r7) goto L_0x0039
                boolean r5 = r9.parseUnknownField(r10, r2, r11, r6)     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                if (r5 != 0) goto L_0x0016
                goto L_0x00c7
            L_0x0039:
                r6 = r4 & 8
                if (r6 == r5) goto L_0x0045
                java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r9.class__ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r4 = r5
            L_0x0045:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r6 = r9.class__     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r10.readMessage(r7, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r11)     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r6.add(r7)     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                goto L_0x0016
            L_0x0051:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r7 = 4
                r6 = r6 & r7
                if (r6 != r7) goto L_0x005d
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r6 = r9.package_     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$Builder r8 = r6.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
            L_0x005d:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r10.readMessage(r6, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r11)     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package) r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r9.package_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                if (r8 == 0) goto L_0x0072
                r8.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package) r6)     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r6 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r9.package_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
            L_0x0072:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r6 = r6 | r7
                r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                goto L_0x0016
            L_0x0078:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r7 = 2
                r6 = r6 & r7
                if (r6 != r7) goto L_0x0084
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r6 = r9.qualifiedNames_     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$Builder r8 = r6.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
            L_0x0084:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r10.readMessage(r6, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r11)     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable) r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r9.qualifiedNames_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                if (r8 == 0) goto L_0x0099
                r8.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable) r6)     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r6 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r9.qualifiedNames_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
            L_0x0099:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r6 = r6 | r7
                r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                goto L_0x0016
            L_0x00a0:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r6 = r6 & r1
                if (r6 != r1) goto L_0x00ab
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r6 = r9.strings_     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$Builder r8 = r6.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
            L_0x00ab:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r10.readMessage(r6, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r11)     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable) r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r9.strings_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                if (r8 == 0) goto L_0x00c0
                r8.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable) r6)     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r6 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r9.strings_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
            L_0x00c0:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                r6 = r6 | r1
                r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00db, IOException -> 0x00cc }
                goto L_0x0016
            L_0x00c7:
                r3 = r1
                goto L_0x0016
            L_0x00ca:
                r10 = move-exception
                goto L_0x00e1
            L_0x00cc:
                r10 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r11 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x00ca }
                java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x00ca }
                r11.<init>(r10)     // Catch:{ all -> 0x00ca }
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r10 = r11.setUnfinishedMessage(r9)     // Catch:{ all -> 0x00ca }
                throw r10     // Catch:{ all -> 0x00ca }
            L_0x00db:
                r10 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r10 = r10.setUnfinishedMessage(r9)     // Catch:{ all -> 0x00ca }
                throw r10     // Catch:{ all -> 0x00ca }
            L_0x00e1:
                r11 = r4 & 8
                if (r11 != r5) goto L_0x00ed
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r11 = r9.class__
                java.util.List r11 = java.util.Collections.unmodifiableList(r11)
                r9.class__ = r11
            L_0x00ed:
                r2.flush()     // Catch:{ IOException -> 0x00f0, all -> 0x00f7 }
            L_0x00f0:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r0.toByteString()
                r9.unknownFields = r11
                goto L_0x00ff
            L_0x00f7:
                r10 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r0.toByteString()
                r9.unknownFields = r11
                throw r10
            L_0x00ff:
                r9.makeExtensionsImmutable()
                throw r10
            L_0x0103:
                r10 = r4 & 8
                if (r10 != r5) goto L_0x010f
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r10 = r9.class__
                java.util.List r10 = java.util.Collections.unmodifiableList(r10)
                r9.class__ = r10
            L_0x010f:
                r2.flush()     // Catch:{ IOException -> 0x0112, all -> 0x0119 }
            L_0x0112:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r10 = r0.toByteString()
                r9.unknownFields = r10
                goto L_0x0121
            L_0x0119:
                r10 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r0.toByteString()
                r9.unknownFields = r11
                throw r10
            L_0x0121:
                r9.makeExtensionsImmutable()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }

        static {
            PackageFragment packageFragment = new PackageFragment(true);
            defaultInstance = packageFragment;
            packageFragment.initFields();
        }

        public Parser<PackageFragment> getParserForType() {
            return PARSER;
        }

        public boolean hasStrings() {
            return (this.bitField0_ & 1) == 1;
        }

        public StringTable getStrings() {
            return this.strings_;
        }

        public boolean hasQualifiedNames() {
            return (this.bitField0_ & 2) == 2;
        }

        public QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        public boolean hasPackage() {
            return (this.bitField0_ & 4) == 4;
        }

        public Package getPackage() {
            return this.package_;
        }

        public List<Class> getClass_List() {
            return this.class__;
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public Class getClass_(int i) {
            return this.class__.get(i);
        }

        private void initFields() {
            this.strings_ = StringTable.getDefaultInstance();
            this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            this.package_ = Package.getDefaultInstance();
            this.class__ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasPackage() || getPackage().isInitialized()) {
                for (int i = 0; i < getClass_Count(); i++) {
                    if (!getClass_(i).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.package_);
            }
            for (int i = 0; i < this.class__.size(); i++) {
                codedOutputStream.writeMessage(4, this.class__.get(i));
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.strings_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, this.package_);
            }
            for (int i2 = 0; i2 < this.class__.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, this.class__.get(i2));
            }
            int extensionsSerializedSize = computeMessageSize + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static PackageFragment parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(PackageFragment packageFragment) {
            return newBuilder().mergeFrom(packageFragment);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<PackageFragment, Builder> implements PackageFragmentOrBuilder {
            private int bitField0_;
            private List<Class> class__ = Collections.emptyList();
            private Package package_ = Package.getDefaultInstance();
            private QualifiedNameTable qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            private StringTable strings_ = StringTable.getDefaultInstance();

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            public PackageFragment build() {
                PackageFragment buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public PackageFragment buildPartial() {
                PackageFragment packageFragment = new PackageFragment((GeneratedMessageLite.ExtendableBuilder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                StringTable unused = packageFragment.strings_ = this.strings_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                QualifiedNameTable unused2 = packageFragment.qualifiedNames_ = this.qualifiedNames_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Package unused3 = packageFragment.package_ = this.package_;
                if ((this.bitField0_ & 8) == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
                    this.bitField0_ &= -9;
                }
                List unused4 = packageFragment.class__ = this.class__;
                int unused5 = packageFragment.bitField0_ = i2;
                return packageFragment;
            }

            public Builder mergeFrom(PackageFragment packageFragment) {
                if (packageFragment == PackageFragment.getDefaultInstance()) {
                    return this;
                }
                if (packageFragment.hasStrings()) {
                    mergeStrings(packageFragment.getStrings());
                }
                if (packageFragment.hasQualifiedNames()) {
                    mergeQualifiedNames(packageFragment.getQualifiedNames());
                }
                if (packageFragment.hasPackage()) {
                    mergePackage(packageFragment.getPackage());
                }
                if (!packageFragment.class__.isEmpty()) {
                    if (this.class__.isEmpty()) {
                        this.class__ = packageFragment.class__;
                        this.bitField0_ &= -9;
                    } else {
                        ensureClass_IsMutable();
                        this.class__.addAll(packageFragment.class__);
                    }
                }
                mergeExtensionFields(packageFragment);
                setUnknownFields(getUnknownFields().concat(packageFragment.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                    return false;
                }
                if (hasPackage() && !getPackage().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < getClass_Count(); i++) {
                    if (!getClass_(i).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                PackageFragment packageFragment;
                PackageFragment packageFragment2 = null;
                try {
                    PackageFragment parsePartialFrom = PackageFragment.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    packageFragment = (PackageFragment) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    packageFragment2 = packageFragment;
                }
                if (packageFragment2 != null) {
                    mergeFrom(packageFragment2);
                }
                throw th;
            }

            public Builder mergeStrings(StringTable stringTable) {
                if ((this.bitField0_ & 1) != 1 || this.strings_ == StringTable.getDefaultInstance()) {
                    this.strings_ = stringTable;
                } else {
                    this.strings_ = StringTable.newBuilder(this.strings_).mergeFrom(stringTable).buildPartial();
                }
                this.bitField0_ |= 1;
                return this;
            }

            public boolean hasQualifiedNames() {
                return (this.bitField0_ & 2) == 2;
            }

            public QualifiedNameTable getQualifiedNames() {
                return this.qualifiedNames_;
            }

            public Builder mergeQualifiedNames(QualifiedNameTable qualifiedNameTable) {
                if ((this.bitField0_ & 2) != 2 || this.qualifiedNames_ == QualifiedNameTable.getDefaultInstance()) {
                    this.qualifiedNames_ = qualifiedNameTable;
                } else {
                    this.qualifiedNames_ = QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(qualifiedNameTable).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public boolean hasPackage() {
                return (this.bitField0_ & 4) == 4;
            }

            public Package getPackage() {
                return this.package_;
            }

            public Builder mergePackage(Package packageR) {
                if ((this.bitField0_ & 4) != 4 || this.package_ == Package.getDefaultInstance()) {
                    this.package_ = packageR;
                } else {
                    this.package_ = Package.newBuilder(this.package_).mergeFrom(packageR).buildPartial();
                }
                this.bitField0_ |= 4;
                return this;
            }

            private void ensureClass_IsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.class__ = new ArrayList(this.class__);
                    this.bitField0_ |= 8;
                }
            }

            public int getClass_Count() {
                return this.class__.size();
            }

            public Class getClass_(int i) {
                return this.class__.get(i);
            }
        }
    }

    public static final class Contract extends GeneratedMessageLite implements ContractOrBuilder {
        public static Parser<Contract> PARSER = new AbstractParser<Contract>() {
            public Contract parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Contract(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Contract defaultInstance;
        /* access modifiers changed from: private */
        public List<Effect> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        private Contract(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Contract(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Contract getDefaultInstance() {
            return defaultInstance;
        }

        public Contract getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Contract(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2) {
                                this.effect_ = new ArrayList();
                                z2 = true;
                            }
                            this.effect_.add(codedInputStream.readMessage(Effect.PARSER, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2) {
                        this.effect_ = Collections.unmodifiableList(this.effect_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2) {
                this.effect_ = Collections.unmodifiableList(this.effect_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            Contract contract = new Contract(true);
            defaultInstance = contract;
            contract.initFields();
        }

        public Parser<Contract> getParserForType() {
            return PARSER;
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        public Effect getEffect(int i) {
            return this.effect_.get(i);
        }

        private void initFields() {
            this.effect_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < getEffectCount(); i++) {
                if (!getEffect(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.effect_.size(); i++) {
                codedOutputStream.writeMessage(1, this.effect_.get(i));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.effect_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.effect_.get(i3));
            }
            int size = i2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Contract contract) {
            return newBuilder().mergeFrom(contract);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Contract, Builder> implements ContractOrBuilder {
            private int bitField0_;
            private List<Effect> effect_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
            }

            public Contract build() {
                Contract buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public Contract buildPartial() {
                Contract contract = new Contract((GeneratedMessageLite.Builder) this);
                if ((this.bitField0_ & 1) == 1) {
                    this.effect_ = Collections.unmodifiableList(this.effect_);
                    this.bitField0_ &= -2;
                }
                List unused = contract.effect_ = this.effect_;
                return contract;
            }

            public Builder mergeFrom(Contract contract) {
                if (contract == Contract.getDefaultInstance()) {
                    return this;
                }
                if (!contract.effect_.isEmpty()) {
                    if (this.effect_.isEmpty()) {
                        this.effect_ = contract.effect_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureEffectIsMutable();
                        this.effect_.addAll(contract.effect_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(contract.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getEffectCount(); i++) {
                    if (!getEffect(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Contract contract;
                Contract contract2 = null;
                try {
                    Contract parsePartialFrom = Contract.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    contract = (Contract) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    contract2 = contract;
                }
                if (contract2 != null) {
                    mergeFrom(contract2);
                }
                throw th;
            }

            private void ensureEffectIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.effect_ = new ArrayList(this.effect_);
                    this.bitField0_ |= 1;
                }
            }

            public int getEffectCount() {
                return this.effect_.size();
            }

            public Effect getEffect(int i) {
                return this.effect_.get(i);
            }
        }
    }

    public static final class Effect extends GeneratedMessageLite implements EffectOrBuilder {
        public static Parser<Effect> PARSER = new AbstractParser<Effect>() {
            public Effect parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Effect(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Effect defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public Expression conclusionOfConditionalEffect_;
        /* access modifiers changed from: private */
        public List<Expression> effectConstructorArgument_;
        /* access modifiers changed from: private */
        public EffectType effectType_;
        /* access modifiers changed from: private */
        public InvocationKind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        private Effect(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Effect(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Effect getDefaultInstance() {
            return defaultInstance;
        }

        public Effect getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Effect(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            int readEnum = codedInputStream.readEnum();
                            EffectType valueOf = EffectType.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 1;
                                this.effectType_ = valueOf;
                            }
                        } else if (readTag == 18) {
                            if (!(z2 & true)) {
                                this.effectConstructorArgument_ = new ArrayList();
                                z2 = true;
                            }
                            this.effectConstructorArgument_.add(codedInputStream.readMessage(Expression.PARSER, extensionRegistryLite));
                        } else if (readTag == 26) {
                            Expression.Builder builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                            Expression expression = (Expression) codedInputStream.readMessage(Expression.PARSER, extensionRegistryLite);
                            this.conclusionOfConditionalEffect_ = expression;
                            if (builder != null) {
                                builder.mergeFrom(expression);
                                this.conclusionOfConditionalEffect_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        } else if (readTag == 32) {
                            int readEnum2 = codedInputStream.readEnum();
                            InvocationKind valueOf2 = InvocationKind.valueOf(readEnum2);
                            if (valueOf2 == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum2);
                            } else {
                                this.bitField0_ |= 4;
                                this.kind_ = valueOf2;
                            }
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            Effect effect = new Effect(true);
            defaultInstance = effect;
            effect.initFields();
        }

        public Parser<Effect> getParserForType() {
            return PARSER;
        }

        public enum EffectType implements Internal.EnumLite {
            RETURNS_CONSTANT(0, 0),
            CALLS(1, 1),
            RETURNS_NOT_NULL(2, 2);
            
            private static Internal.EnumLiteMap<EffectType> internalValueMap;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<EffectType>() {
                    public EffectType findValueByNumber(int i) {
                        return EffectType.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static EffectType valueOf(int i) {
                if (i == 0) {
                    return RETURNS_CONSTANT;
                }
                if (i == 1) {
                    return CALLS;
                }
                if (i != 2) {
                    return null;
                }
                return RETURNS_NOT_NULL;
            }

            private EffectType(int i, int i2) {
                this.value = i2;
            }
        }

        public enum InvocationKind implements Internal.EnumLite {
            AT_MOST_ONCE(0, 0),
            EXACTLY_ONCE(1, 1),
            AT_LEAST_ONCE(2, 2);
            
            private static Internal.EnumLiteMap<InvocationKind> internalValueMap;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<InvocationKind>() {
                    public InvocationKind findValueByNumber(int i) {
                        return InvocationKind.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static InvocationKind valueOf(int i) {
                if (i == 0) {
                    return AT_MOST_ONCE;
                }
                if (i == 1) {
                    return EXACTLY_ONCE;
                }
                if (i != 2) {
                    return null;
                }
                return AT_LEAST_ONCE;
            }

            private InvocationKind(int i, int i2) {
                this.value = i2;
            }
        }

        public boolean hasEffectType() {
            return (this.bitField0_ & 1) == 1;
        }

        public EffectType getEffectType() {
            return this.effectType_;
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        public Expression getEffectConstructorArgument(int i) {
            return this.effectConstructorArgument_.get(i);
        }

        public boolean hasConclusionOfConditionalEffect() {
            return (this.bitField0_ & 2) == 2;
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        public boolean hasKind() {
            return (this.bitField0_ & 4) == 4;
        }

        public InvocationKind getKind() {
            return this.kind_;
        }

        private void initFields() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < getEffectConstructorArgumentCount(); i++) {
                if (!getEffectConstructorArgument(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.effectType_.getNumber());
            }
            for (int i = 0; i < this.effectConstructorArgument_.size(); i++) {
                codedOutputStream.writeMessage(2, this.effectConstructorArgument_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(4, this.kind_.getNumber());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) : 0;
            for (int i2 = 0; i2 < this.effectConstructorArgument_.size(); i2++) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
            }
            int size = computeEnumSize + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Effect effect) {
            return newBuilder().mergeFrom(effect);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Effect, Builder> implements EffectOrBuilder {
            private int bitField0_;
            private Expression conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            private List<Expression> effectConstructorArgument_ = Collections.emptyList();
            private EffectType effectType_ = EffectType.RETURNS_CONSTANT;
            private InvocationKind kind_ = InvocationKind.AT_MOST_ONCE;

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            public Effect build() {
                Effect buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public Effect buildPartial() {
                Effect effect = new Effect((GeneratedMessageLite.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                EffectType unused = effect.effectType_ = this.effectType_;
                if ((this.bitField0_ & 2) == 2) {
                    this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                    this.bitField0_ &= -3;
                }
                List unused2 = effect.effectConstructorArgument_ = this.effectConstructorArgument_;
                if ((i & 4) == 4) {
                    i2 |= 2;
                }
                Expression unused3 = effect.conclusionOfConditionalEffect_ = this.conclusionOfConditionalEffect_;
                if ((i & 8) == 8) {
                    i2 |= 4;
                }
                InvocationKind unused4 = effect.kind_ = this.kind_;
                int unused5 = effect.bitField0_ = i2;
                return effect;
            }

            public Builder mergeFrom(Effect effect) {
                if (effect == Effect.getDefaultInstance()) {
                    return this;
                }
                if (effect.hasEffectType()) {
                    setEffectType(effect.getEffectType());
                }
                if (!effect.effectConstructorArgument_.isEmpty()) {
                    if (this.effectConstructorArgument_.isEmpty()) {
                        this.effectConstructorArgument_ = effect.effectConstructorArgument_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureEffectConstructorArgumentIsMutable();
                        this.effectConstructorArgument_.addAll(effect.effectConstructorArgument_);
                    }
                }
                if (effect.hasConclusionOfConditionalEffect()) {
                    mergeConclusionOfConditionalEffect(effect.getConclusionOfConditionalEffect());
                }
                if (effect.hasKind()) {
                    setKind(effect.getKind());
                }
                setUnknownFields(getUnknownFields().concat(effect.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getEffectConstructorArgumentCount(); i++) {
                    if (!getEffectConstructorArgument(i).isInitialized()) {
                        return false;
                    }
                }
                if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Effect effect;
                Effect effect2 = null;
                try {
                    Effect parsePartialFrom = Effect.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    effect = (Effect) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    effect2 = effect;
                }
                if (effect2 != null) {
                    mergeFrom(effect2);
                }
                throw th;
            }

            public Builder setEffectType(EffectType effectType) {
                effectType.getClass();
                this.bitField0_ |= 1;
                this.effectType_ = effectType;
                return this;
            }

            private void ensureEffectConstructorArgumentIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
                    this.bitField0_ |= 2;
                }
            }

            public int getEffectConstructorArgumentCount() {
                return this.effectConstructorArgument_.size();
            }

            public Expression getEffectConstructorArgument(int i) {
                return this.effectConstructorArgument_.get(i);
            }

            public boolean hasConclusionOfConditionalEffect() {
                return (this.bitField0_ & 4) == 4;
            }

            public Expression getConclusionOfConditionalEffect() {
                return this.conclusionOfConditionalEffect_;
            }

            public Builder mergeConclusionOfConditionalEffect(Expression expression) {
                if ((this.bitField0_ & 4) != 4 || this.conclusionOfConditionalEffect_ == Expression.getDefaultInstance()) {
                    this.conclusionOfConditionalEffect_ = expression;
                } else {
                    this.conclusionOfConditionalEffect_ = Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(expression).buildPartial();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setKind(InvocationKind invocationKind) {
                invocationKind.getClass();
                this.bitField0_ |= 8;
                this.kind_ = invocationKind;
                return this;
            }
        }
    }

    public static final class Expression extends GeneratedMessageLite implements ExpressionOrBuilder {
        public static Parser<Expression> PARSER = new AbstractParser<Expression>() {
            public Expression parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Expression(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Expression defaultInstance;
        /* access modifiers changed from: private */
        public List<Expression> andArgument_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public ConstantValue constantValue_;
        /* access modifiers changed from: private */
        public int flags_;
        /* access modifiers changed from: private */
        public int isInstanceTypeId_;
        /* access modifiers changed from: private */
        public Type isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Expression> orArgument_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public int valueParameterReference_;

        private Expression(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Expression(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Expression getDefaultInstance() {
            return defaultInstance;
        }

        public Expression getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Expression(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.valueParameterReference_ = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            int readEnum = codedInputStream.readEnum();
                            ConstantValue valueOf = ConstantValue.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 4;
                                this.constantValue_ = valueOf;
                            }
                        } else if (readTag == 34) {
                            Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                            Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.isInstanceType_ = type;
                            if (builder != null) {
                                builder.mergeFrom(type);
                                this.isInstanceType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                        } else if (readTag == 40) {
                            this.bitField0_ |= 16;
                            this.isInstanceTypeId_ = codedInputStream.readInt32();
                        } else if (readTag == 50) {
                            if (!(z2 & true)) {
                                this.andArgument_ = new ArrayList();
                                z2 |= true;
                            }
                            this.andArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                        } else if (readTag == 58) {
                            if (!(z2 & true)) {
                                this.orArgument_ = new ArrayList();
                                z2 |= true;
                            }
                            this.orArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    }
                    if (z2 & true) {
                        this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
            }
            if (z2 & true) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            Expression expression = new Expression(true);
            defaultInstance = expression;
            expression.initFields();
        }

        public Parser<Expression> getParserForType() {
            return PARSER;
        }

        public enum ConstantValue implements Internal.EnumLite {
            TRUE(0, 0),
            FALSE(1, 1),
            NULL(2, 2);
            
            private static Internal.EnumLiteMap<ConstantValue> internalValueMap;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<ConstantValue>() {
                    public ConstantValue findValueByNumber(int i) {
                        return ConstantValue.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static ConstantValue valueOf(int i) {
                if (i == 0) {
                    return TRUE;
                }
                if (i == 1) {
                    return FALSE;
                }
                if (i != 2) {
                    return null;
                }
                return NULL;
            }

            private ConstantValue(int i, int i2) {
                this.value = i2;
            }
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasValueParameterReference() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        public boolean hasConstantValue() {
            return (this.bitField0_ & 4) == 4;
        }

        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        public boolean hasIsInstanceType() {
            return (this.bitField0_ & 8) == 8;
        }

        public Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        public boolean hasIsInstanceTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public Expression getAndArgument(int i) {
            return this.andArgument_.get(i);
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        public Expression getOrArgument(int i) {
            return this.orArgument_.get(i);
        }

        private void initFields() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!hasIsInstanceType() || getIsInstanceType().isInitialized()) {
                for (int i = 0; i < getAndArgumentCount(); i++) {
                    if (!getAndArgument(i).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                for (int i2 = 0; i2 < getOrArgumentCount(); i2++) {
                    if (!getOrArgument(i2).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.isInstanceTypeId_);
            }
            for (int i = 0; i < this.andArgument_.size(); i++) {
                codedOutputStream.writeMessage(6, this.andArgument_.get(i));
            }
            for (int i2 = 0; i2 < this.orArgument_.size(); i2++) {
                codedOutputStream.writeMessage(7, this.orArgument_.get(i2));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
            }
            for (int i2 = 0; i2 < this.andArgument_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.andArgument_.get(i2));
            }
            for (int i3 = 0; i3 < this.orArgument_.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(7, this.orArgument_.get(i3));
            }
            int size = computeInt32Size + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Expression expression) {
            return newBuilder().mergeFrom(expression);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Expression, Builder> implements ExpressionOrBuilder {
            private List<Expression> andArgument_ = Collections.emptyList();
            private int bitField0_;
            private ConstantValue constantValue_ = ConstantValue.TRUE;
            private int flags_;
            private int isInstanceTypeId_;
            private Type isInstanceType_ = Type.getDefaultInstance();
            private List<Expression> orArgument_ = Collections.emptyList();
            private int valueParameterReference_;

            private void maybeForceBuilderInitialization() {
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            public Expression build() {
                Expression buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public Expression buildPartial() {
                Expression expression = new Expression((GeneratedMessageLite.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                int unused = expression.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = expression.valueParameterReference_ = this.valueParameterReference_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                ConstantValue unused3 = expression.constantValue_ = this.constantValue_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                Type unused4 = expression.isInstanceType_ = this.isInstanceType_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                int unused5 = expression.isInstanceTypeId_ = this.isInstanceTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    this.bitField0_ &= -33;
                }
                List unused6 = expression.andArgument_ = this.andArgument_;
                if ((this.bitField0_ & 64) == 64) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                    this.bitField0_ &= -65;
                }
                List unused7 = expression.orArgument_ = this.orArgument_;
                int unused8 = expression.bitField0_ = i2;
                return expression;
            }

            public Builder mergeFrom(Expression expression) {
                if (expression == Expression.getDefaultInstance()) {
                    return this;
                }
                if (expression.hasFlags()) {
                    setFlags(expression.getFlags());
                }
                if (expression.hasValueParameterReference()) {
                    setValueParameterReference(expression.getValueParameterReference());
                }
                if (expression.hasConstantValue()) {
                    setConstantValue(expression.getConstantValue());
                }
                if (expression.hasIsInstanceType()) {
                    mergeIsInstanceType(expression.getIsInstanceType());
                }
                if (expression.hasIsInstanceTypeId()) {
                    setIsInstanceTypeId(expression.getIsInstanceTypeId());
                }
                if (!expression.andArgument_.isEmpty()) {
                    if (this.andArgument_.isEmpty()) {
                        this.andArgument_ = expression.andArgument_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureAndArgumentIsMutable();
                        this.andArgument_.addAll(expression.andArgument_);
                    }
                }
                if (!expression.orArgument_.isEmpty()) {
                    if (this.orArgument_.isEmpty()) {
                        this.orArgument_ = expression.orArgument_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureOrArgumentIsMutable();
                        this.orArgument_.addAll(expression.orArgument_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(expression.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < getAndArgumentCount(); i++) {
                    if (!getAndArgument(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < getOrArgumentCount(); i2++) {
                    if (!getOrArgument(i2).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Expression expression;
                Expression expression2 = null;
                try {
                    Expression parsePartialFrom = Expression.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    expression = (Expression) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    expression2 = expression;
                }
                if (expression2 != null) {
                    mergeFrom(expression2);
                }
                throw th;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public Builder setValueParameterReference(int i) {
                this.bitField0_ |= 2;
                this.valueParameterReference_ = i;
                return this;
            }

            public Builder setConstantValue(ConstantValue constantValue) {
                constantValue.getClass();
                this.bitField0_ |= 4;
                this.constantValue_ = constantValue;
                return this;
            }

            public boolean hasIsInstanceType() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type getIsInstanceType() {
                return this.isInstanceType_;
            }

            public Builder mergeIsInstanceType(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.isInstanceType_ == Type.getDefaultInstance()) {
                    this.isInstanceType_ = type;
                } else {
                    this.isInstanceType_ = Type.newBuilder(this.isInstanceType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setIsInstanceTypeId(int i) {
                this.bitField0_ |= 16;
                this.isInstanceTypeId_ = i;
                return this;
            }

            private void ensureAndArgumentIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.andArgument_ = new ArrayList(this.andArgument_);
                    this.bitField0_ |= 32;
                }
            }

            public int getAndArgumentCount() {
                return this.andArgument_.size();
            }

            public Expression getAndArgument(int i) {
                return this.andArgument_.get(i);
            }

            private void ensureOrArgumentIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.orArgument_ = new ArrayList(this.orArgument_);
                    this.bitField0_ |= 64;
                }
            }

            public int getOrArgumentCount() {
                return this.orArgument_.size();
            }

            public Expression getOrArgument(int i) {
                return this.orArgument_.get(i);
            }
        }
    }
}
