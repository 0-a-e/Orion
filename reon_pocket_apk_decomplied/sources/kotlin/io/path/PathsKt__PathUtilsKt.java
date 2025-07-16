package kotlin.io.path;

import androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001H\b¢\u0006\u0002\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010\"\u001aK\u0010#\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010%\u001aB\u0010#\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00022\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0001\u001a4\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020,2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\r\u00102\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u00103\u001a\u00020\u0001*\u00020\u0002H\b\u001a.\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\b¢\u0006\u0002\u00108\u001a\u001f\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\b\u001a.\u0010;\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010<\u001a.\u0010=\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010<\u001a.\u0010>\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010<\u001a\u0015\u0010?\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u0002H\b\u001a-\u0010@\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010<\u001a6\u0010A\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010B\u001a\r\u0010C\u001a\u000200*\u00020\u0002H\b\u001a\r\u0010D\u001a\u00020:*\u00020\u0002H\b\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\n\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001H\n\u001a&\u0010G\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010I\u001a2\u0010J\u001a\u0002HK\"\n\b\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010M\u001a4\u0010N\u001a\u0004\u0018\u0001HK\"\n\b\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010M\u001a\r\u0010O\u001a\u00020P*\u00020\u0002H\b\u001a\r\u0010Q\u001a\u00020R*\u00020\u0002H\b\u001a.\u0010S\u001a\u000200*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u00012\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002000.H\bø\u0001\u0000\u001a0\u0010V\u001a\u0004\u0018\u00010W*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010Y\u001a&\u0010Z\u001a\u00020[*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010\\\u001a(\u0010]\u001a\u0004\u0018\u00010^*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010_\u001a,\u0010`\u001a\b\u0012\u0004\u0012\u00020b0a*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010c\u001a&\u0010d\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010I\u001a\r\u0010e\u001a\u00020:*\u00020\u0002H\b\u001a\r\u0010f\u001a\u00020:*\u00020\u0002H\b\u001a\r\u0010g\u001a\u00020:*\u00020\u0002H\b\u001a&\u0010h\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010I\u001a\u0015\u0010i\u001a\u00020:*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\b\u001a\r\u0010j\u001a\u00020:*\u00020\u0002H\b\u001a\r\u0010k\u001a\u00020:*\u00020\u0002H\b\u001a\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00020m*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u0001H\u0007\u001a.\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\b¢\u0006\u0002\u00108\u001a\u001f\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\b\u001a&\u0010o\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010I\u001a2\u0010p\u001a\u0002Hq\"\n\b\u0000\u0010q\u0018\u0001*\u00020r*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010s\u001a<\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010W0t*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010u\u001a\r\u0010v\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0014\u0010w\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0016\u0010x\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0014\u0010y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a8\u0010z\u001a\u00020\u0002*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\b\u0010{\u001a\u0004\u0018\u00010W2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\b¢\u0006\u0002\u0010|\u001a\u0015\u0010}\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020[H\b\u001a\u0015\u0010~\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020^H\b\u001a\u001b\u0010\u001a\u00020\u0002*\u00020\u00022\f\u0010{\u001a\b\u0012\u0004\u0012\u00020b0aH\b\u001a\u000f\u0010\u0001\u001a\u00020\u0002*\u00030\u0001H\b\u001aF\u0010\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u00012\u001b\u0010\u0001\u001a\u0016\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0005\u0012\u0003H\u00010.H\bø\u0001\u0000¢\u0006\u0003\u0010\u0001\u001a3\u0010\u0001\u001a\u000200*\u00020\u00022\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020,2\n\b\u0002\u0010\u0001\u001a\u00030\u00012\t\b\u0002\u0010\u0001\u001a\u00020:H\u0007\u001aJ\u0010\u0001\u001a\u000200*\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u00030\u00012\t\b\u0002\u0010\u0001\u001a\u00020:2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a0\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00022\u0014\u00106\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u00010\u001a\"\u00030\u0001H\u0007¢\u0006\u0003\u0010\u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"extension", "", "Ljava/nio/file/Path;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "name", "getName$annotations", "getName", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "pathString", "getPathString$annotations", "getPathString", "Path", "path", "base", "subpaths", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "createTempDirectory", "directory", "prefix", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempFile", "suffix", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "fileAttributeViewNotAvailable", "", "attributeViewClass", "Ljava/lang/Class;", "fileVisitor", "Ljava/nio/file/FileVisitor;", "builderAction", "Lkotlin/Function1;", "Lkotlin/io/path/FileVisitorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "absolute", "absolutePathString", "copyTo", "target", "options", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "overwrite", "", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "createParentDirectories", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "deleteExisting", "deleteIfExists", "div", "other", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "fileAttributesView", "V", "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "fileSize", "", "fileStore", "Ljava/nio/file/FileStore;", "forEachDirectoryEntry", "glob", "action", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "isSymbolicLink", "isWritable", "listDirectoryEntries", "", "moveTo", "notExists", "readAttributes", "A", "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "setOwner", "setPosixFilePermissions", "toPath", "Ljava/net/URI;", "useDirectoryEntries", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "visitFileTree", "visitor", "maxDepth", "", "followLinks", "walk", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
/* compiled from: PathUtils.kt */
class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    public static /* synthetic */ void getExtension$annotations(Path path) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path path) {
    }

    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path path) {
    }

    public static /* synthetic */ void getName$annotations(Path path) {
    }

    public static /* synthetic */ void getNameWithoutExtension$annotations(Path path) {
    }

    public static /* synthetic */ void getPathString$annotations(Path path) {
    }

    public static final String getName(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path m = Trace$$ExternalSyntheticApiModelOutline0.m(path);
        String obj = m != null ? m.toString() : null;
        return obj == null ? "" : obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r3 = kotlin.text.StringsKt.substringBeforeLast$default((r3 = r3.toString()), com.amazonaws.services.s3.model.InstructionFileId.DOT, (java.lang.String) null, 2, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getNameWithoutExtension(java.nio.file.Path r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.nio.file.Path r3 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r3)
            if (r3 == 0) goto L_0x001b
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L_0x001b
            java.lang.String r0 = "."
            r1 = 2
            r2 = 0
            java.lang.String r3 = kotlin.text.StringsKt.substringBeforeLast$default((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r2, (int) r1, (java.lang.Object) r2)
            if (r3 != 0) goto L_0x001d
        L_0x001b:
            java.lang.String r3 = ""
        L_0x001d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.getNameWithoutExtension(java.nio.file.Path):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r2 = kotlin.text.StringsKt.substringAfterLast((r2 = r2.toString()), '.', "");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getExtension(java.nio.file.Path r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.nio.file.Path r2 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r2)
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x001d
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L_0x001d
            r1 = 46
            java.lang.String r2 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r2, (char) r1, (java.lang.String) r0)
            if (r2 != 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.getExtension(java.nio.file.Path):java.lang.String");
    }

    private static final String getPathString(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.toString();
    }

    public static final String getInvariantSeparatorsPathString(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        String m = Trace$$ExternalSyntheticApiModelOutline0.m(path).getSeparator();
        if (Intrinsics.areEqual((Object) m, (Object) "/")) {
            return path.toString();
        }
        String obj = path.toString();
        Intrinsics.checkNotNull(m);
        return StringsKt.replace$default(obj, m, "/", false, 4, (Object) null);
    }

    private static final String getInvariantSeparatorsPath(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return PathsKt.getInvariantSeparatorsPathString(path);
    }

    private static final Path absolute(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path m$1 = StreamsKt$$ExternalSyntheticApiModelOutline0.m$1(path);
        Intrinsics.checkNotNullExpressionValue(m$1, "toAbsolutePath(...)");
        return m$1;
    }

    private static final String absolutePathString(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m$1(path).toString();
    }

    public static final Path relativeTo(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "base");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(path, path2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + path + "\nbase path: " + path2, e);
        }
    }

    public static final Path relativeToOrSelf(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "base");
        Path relativeToOrNull = PathsKt.relativeToOrNull(path, path2);
        return relativeToOrNull == null ? path : relativeToOrNull;
    }

    public static final Path relativeToOrNull(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "base");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(path, path2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static /* synthetic */ Path copyTo$default(Path path, Path path2, boolean z, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StreamsKt$$ExternalSyntheticApiModelOutline0.m()} : new CopyOption[0];
        Path m = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "copy(...)");
        return m;
    }

    private static final Path copyTo(Path path, Path path2, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StreamsKt$$ExternalSyntheticApiModelOutline0.m()} : new CopyOption[0];
        Path m = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "copy(...)");
        return m;
    }

    private static final Path copyTo(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Intrinsics.checkNotNullParameter(copyOptionArr, "options");
        Path m = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "copy(...)");
        return m;
    }

    private static final boolean exists(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean notExists(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean isRegularFile(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean isDirectory(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean isSymbolicLink(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m$1(path);
    }

    private static final boolean isExecutable(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isExecutable(path);
    }

    private static final boolean isHidden(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isHidden(path);
    }

    private static final boolean isReadable(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isReadable(path);
    }

    private static final boolean isWritable(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isWritable(path);
    }

    private static final boolean isSameFileAs(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "other");
        return Trace$$ExternalSyntheticApiModelOutline0.m(path, path2);
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path path, String str, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = "*";
        }
        return PathsKt.listDirectoryEntries(path, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<java.nio.file.Path> listDirectoryEntries(java.nio.file.Path r1, java.lang.String r2) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "glob"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.nio.file.DirectoryStream r1 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r1, (java.lang.String) r2)
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.nio.file.DirectoryStream r2 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r1)     // Catch:{ all -> 0x0022 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x0022 }
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ all -> 0x0022 }
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)     // Catch:{ all -> 0x0022 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            return r2
        L_0x0022:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.listDirectoryEntries(java.nio.file.Path, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r0 != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object useDirectoryEntries$default(java.nio.file.Path r0, java.lang.String r1, kotlin.jvm.functions.Function1 r2, int r3, java.lang.Object r4) throws java.io.IOException {
        /*
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0006
            java.lang.String r1 = "*"
        L_0x0006:
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "glob"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.nio.file.DirectoryStream r0 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r0, (java.lang.String) r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            java.nio.file.DirectoryStream r3 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r0)     // Catch:{ all -> 0x0044 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x0044 }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ all -> 0x0044 }
            kotlin.sequences.Sequence r3 = kotlin.collections.CollectionsKt.asSequence(r3)     // Catch:{ all -> 0x0044 }
            java.lang.Object r2 = r2.invoke(r3)     // Catch:{ all -> 0x0044 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            boolean r1 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r4, r4, r1)
            if (r1 == 0) goto L_0x003b
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            goto L_0x0040
        L_0x003b:
            if (r0 == 0) goto L_0x0040
            r0.close()
        L_0x0040:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            return r2
        L_0x0044:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r3 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            boolean r1 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r4, r4, r1)
            if (r1 != 0) goto L_0x0056
            if (r0 == 0) goto L_0x0059
            r0.close()     // Catch:{ all -> 0x0059 }
            goto L_0x0059
        L_0x0056:
            kotlin.io.CloseableKt.closeFinally(r0, r2)
        L_0x0059:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.useDirectoryEntries$default(java.nio.file.Path, java.lang.String, kotlin.jvm.functions.Function1, int, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        if (r2 != null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> T useDirectoryEntries(java.nio.file.Path r2, java.lang.String r3, kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<? extends java.nio.file.Path>, ? extends T> r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "glob"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.nio.file.DirectoryStream r2 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r2, (java.lang.String) r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = 0
            r0 = 1
            java.nio.file.DirectoryStream r1 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r2)     // Catch:{ all -> 0x003f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x003f }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x003f }
            kotlin.sequences.Sequence r1 = kotlin.collections.CollectionsKt.asSequence(r1)     // Catch:{ all -> 0x003f }
            java.lang.Object r4 = r4.invoke(r1)     // Catch:{ all -> 0x003f }
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            boolean r3 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r0, r0, r3)
            if (r3 == 0) goto L_0x0036
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            goto L_0x003b
        L_0x0036:
            if (r2 == 0) goto L_0x003b
            r2.close()
        L_0x003b:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            return r4
        L_0x003f:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            boolean r3 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r0, r0, r3)
            if (r3 != 0) goto L_0x0051
            if (r2 == 0) goto L_0x0054
            r2.close()     // Catch:{ all -> 0x0054 }
            goto L_0x0054
        L_0x0051:
            kotlin.io.CloseableKt.closeFinally(r2, r4)
        L_0x0054:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.useDirectoryEntries(java.nio.file.Path, java.lang.String, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        if (kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r1 != null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0065, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void forEachDirectoryEntry$default(java.nio.file.Path r1, java.lang.String r2, kotlin.jvm.functions.Function1 r3, int r4, java.lang.Object r5) throws java.io.IOException {
        /*
            r5 = 1
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0006
            java.lang.String r2 = "*"
        L_0x0006:
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "glob"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            java.nio.file.DirectoryStream r1 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r1, (java.lang.String) r2)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = 0
            java.nio.file.DirectoryStream r4 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r1)     // Catch:{ all -> 0x0050 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0050 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x0050 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0050 }
        L_0x0029:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x0050 }
            if (r0 == 0) goto L_0x0037
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x0050 }
            r3.invoke(r0)     // Catch:{ all -> 0x0050 }
            goto L_0x0029
        L_0x0037:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0050 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            boolean r2 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r5, r5, r2)
            if (r2 == 0) goto L_0x0047
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            goto L_0x004c
        L_0x0047:
            if (r1 == 0) goto L_0x004c
            r1.close()
        L_0x004c:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            return
        L_0x0050:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r4 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            boolean r2 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r5, r5, r2)
            if (r2 != 0) goto L_0x0062
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ all -> 0x0065 }
            goto L_0x0065
        L_0x0062:
            kotlin.io.CloseableKt.closeFinally(r1, r3)
        L_0x0065:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.forEachDirectoryEntry$default(java.nio.file.Path, java.lang.String, kotlin.jvm.functions.Function1, int, java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (r3 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void forEachDirectoryEntry(java.nio.file.Path r3, java.lang.String r4, kotlin.jvm.functions.Function1<? super java.nio.file.Path, kotlin.Unit> r5) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "glob"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.nio.file.DirectoryStream r3 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r3, (java.lang.String) r4)
            java.io.Closeable r3 = (java.io.Closeable) r3
            r4 = 0
            r0 = 1
            java.nio.file.DirectoryStream r1 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r3)     // Catch:{ all -> 0x004b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x004b }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x004b }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x004b }
        L_0x0024:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0032
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x004b }
            r5.invoke(r2)     // Catch:{ all -> 0x004b }
            goto L_0x0024
        L_0x0032:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004b }
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            boolean r4 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r0, r0, r4)
            if (r4 == 0) goto L_0x0042
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            goto L_0x0047
        L_0x0042:
            if (r3 == 0) goto L_0x0047
            r3.close()
        L_0x0047:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            return
        L_0x004b:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x004d }
        L_0x004d:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            boolean r4 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r0, r0, r4)
            if (r4 != 0) goto L_0x005d
            if (r3 == 0) goto L_0x0060
            r3.close()     // Catch:{ all -> 0x0060 }
            goto L_0x0060
        L_0x005d:
            kotlin.io.CloseableKt.closeFinally(r3, r5)
        L_0x0060:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.forEachDirectoryEntry(java.nio.file.Path, java.lang.String, kotlin.jvm.functions.Function1):void");
    }

    private static final long fileSize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m(path);
    }

    private static final void deleteExisting(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        StreamsKt$$ExternalSyntheticApiModelOutline0.m(path);
    }

    private static final boolean deleteIfExists(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m(path);
    }

    private static final Path createDirectory(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path m$1 = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(m$1, "createDirectory(...)");
        return m$1;
    }

    private static final Path createDirectories(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path m = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "createDirectories(...)");
        return m;
    }

    public static final Path createParentDirectories(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path m$1 = path.getParent();
        if (m$1 != null && !Files.isDirectory(m$1, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
            try {
                FileAttribute[] fileAttributeArr2 = (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length);
                Intrinsics.checkNotNullExpressionValue(Files.createDirectories(m$1, (FileAttribute[]) Arrays.copyOf(fileAttributeArr2, fileAttributeArr2.length)), "createDirectories(...)");
            } catch (FileAlreadyExistsException e) {
                if (!Files.isDirectory(m$1, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    throw e;
                }
            }
        }
        return path;
    }

    private static final Path moveTo(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Intrinsics.checkNotNullParameter(copyOptionArr, "options");
        Path m = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "move(...)");
        return m;
    }

    static /* synthetic */ Path moveTo$default(Path path, Path path2, boolean z, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StreamsKt$$ExternalSyntheticApiModelOutline0.m()} : new CopyOption[0];
        Path m = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "move(...)");
        return m;
    }

    private static final Path moveTo(Path path, Path path2, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StreamsKt$$ExternalSyntheticApiModelOutline0.m()} : new CopyOption[0];
        Path m = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "move(...)");
        return m;
    }

    private static final FileStore fileStore(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        FileStore m = StreamsKt$$ExternalSyntheticApiModelOutline0.m(path);
        Intrinsics.checkNotNullExpressionValue(m, "getFileStore(...)");
        return m;
    }

    private static final Object getAttribute(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(str, "attribute");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final Path setAttribute(Path path, String str, Object obj, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(str, "attribute");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Path m = Files.setAttribute(path, str, obj, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "setAttribute(...)");
        return m;
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        Class m$1 = StreamsKt$$ExternalSyntheticApiModelOutline0.m$1();
        Class cls = m$1;
        return Files.getFileAttributeView(path, m$1, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        Class m$1 = StreamsKt$$ExternalSyntheticApiModelOutline0.m$1();
        Class cls = m$1;
        FileAttributeView m = Files.getFileAttributeView(path, m$1, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (m != null) {
            return StreamsKt$$ExternalSyntheticApiModelOutline0.m((Object) m);
        }
        Intrinsics.reifiedOperationMarker(4, "V");
        Class m$12 = StreamsKt$$ExternalSyntheticApiModelOutline0.m$1();
        Class cls2 = m$12;
        PathsKt.fileAttributeViewNotAvailable(path, m$12);
        throw new KotlinNothingValueException();
    }

    public static final Void fileAttributeViewNotAvailable(Path path, Class<?> cls) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(cls, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + cls + " is not available for the file " + path + '.');
    }

    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Intrinsics.reifiedOperationMarker(4, "A");
        Class m = Trace$$ExternalSyntheticApiModelOutline0.m();
        Class cls = m;
        BasicFileAttributes m2 = Files.readAttributes(path, m, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m2, "readAttributes(...)");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m((Object) m2);
    }

    private static final Map<String, Object> readAttributes(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(str, "attributes");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Map<String, Object> m = StreamsKt$$ExternalSyntheticApiModelOutline0.m(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "readAttributes(...)");
        return m;
    }

    private static final FileTime getLastModifiedTime(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        FileTime m = StreamsKt$$ExternalSyntheticApiModelOutline0.m(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "getLastModifiedTime(...)");
        return m;
    }

    private static final Path setLastModifiedTime(Path path, FileTime fileTime) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(fileTime, "value");
        Path m = Files.setLastModifiedTime(path, fileTime);
        Intrinsics.checkNotNullExpressionValue(m, "setLastModifiedTime(...)");
        return m;
    }

    private static final UserPrincipal getOwner(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final Path setOwner(Path path, UserPrincipal userPrincipal) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(userPrincipal, "value");
        Path m = Files.setOwner(path, userPrincipal);
        Intrinsics.checkNotNullExpressionValue(m, "setOwner(...)");
        return m;
    }

    private static final Set<PosixFilePermission> getPosixFilePermissions(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Set<PosixFilePermission> m = StreamsKt$$ExternalSyntheticApiModelOutline0.m(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "getPosixFilePermissions(...)");
        return m;
    }

    private static final Path setPosixFilePermissions(Path path, Set<? extends PosixFilePermission> set) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(set, "value");
        Path m = Files.setPosixFilePermissions(path, set);
        Intrinsics.checkNotNullExpressionValue(m, "setPosixFilePermissions(...)");
        return m;
    }

    private static final Path createLinkPointingTo(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Path m = StreamsKt$$ExternalSyntheticApiModelOutline0.m(path, path2);
        Intrinsics.checkNotNullExpressionValue(m, "createLink(...)");
        return m;
    }

    private static final Path createSymbolicLinkPointingTo(Path path, Path path2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path m = Files.createSymbolicLink(path, path2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "createSymbolicLink(...)");
        return m;
    }

    private static final Path readSymbolicLink(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path m = StreamsKt$$ExternalSyntheticApiModelOutline0.m(path);
        Intrinsics.checkNotNullExpressionValue(m, "readSymbolicLink(...)");
        return m;
    }

    private static final Path createFile(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path m$2 = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(m$2, "createFile(...)");
        return m$2;
    }

    static /* synthetic */ Path createTempFile$default(String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path m = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "createTempFile(...)");
        return m;
    }

    private static final Path createTempFile(String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path m = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "createTempFile(...)");
        return m;
    }

    public static /* synthetic */ Path createTempFile$default(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return PathsKt.createTempFile(path, str, str2, fileAttributeArr);
    }

    public static final Path createTempFile(Path path, String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        if (path != null) {
            Path m = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(m, "createTempFile(...)");
            return m;
        }
        Path m2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(m2, "createTempFile(...)");
        return m2;
    }

    static /* synthetic */ Path createTempDirectory$default(String str, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path m = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "createTempDirectory(...)");
        return m;
    }

    private static final Path createTempDirectory(String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path m = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "createTempDirectory(...)");
        return m;
    }

    public static /* synthetic */ Path createTempDirectory$default(Path path, String str, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        return PathsKt.createTempDirectory(path, str, fileAttributeArr);
    }

    public static final Path createTempDirectory(Path path, String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        if (path != null) {
            Path m = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(m, "createTempDirectory(...)");
            return m;
        }
        Path m2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(m2, "createTempDirectory(...)");
        return m2;
    }

    private static final Path div(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "other");
        Path m = Trace$$ExternalSyntheticApiModelOutline0.m(path, path2);
        Intrinsics.checkNotNullExpressionValue(m, "resolve(...)");
        return m;
    }

    private static final Path div(Path path, String str) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(str, "other");
        Path m = StreamsKt$$ExternalSyntheticApiModelOutline0.m(path, str);
        Intrinsics.checkNotNullExpressionValue(m, "resolve(...)");
        return m;
    }

    private static final Path Path(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        Path m = Paths.get(str, new String[0]);
        Intrinsics.checkNotNullExpressionValue(m, "get(...)");
        return m;
    }

    private static final Path Path(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, "base");
        Intrinsics.checkNotNullParameter(strArr, "subpaths");
        Path m = Paths.get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "get(...)");
        return m;
    }

    private static final Path toPath(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Path m = Paths.get(uri);
        Intrinsics.checkNotNullExpressionValue(m, "get(...)");
        return m;
    }

    public static final Sequence<Path> walk(Path path, PathWalkOption... pathWalkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(pathWalkOptionArr, "options");
        return new PathTreeWalk(path, pathWalkOptionArr);
    }

    public static /* synthetic */ void visitFileTree$default(Path path, FileVisitor fileVisitor, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        PathsKt.visitFileTree(path, (FileVisitor<Path>) fileVisitor, i, z);
    }

    public static final void visitFileTree(Path path, FileVisitor<Path> fileVisitor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(fileVisitor, "visitor");
        Path unused = Files.walkFileTree(path, z ? SetsKt.setOf(Trace$$ExternalSyntheticApiModelOutline0.m()) : SetsKt.emptySet(), i, fileVisitor);
    }

    public static /* synthetic */ void visitFileTree$default(Path path, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        PathsKt.visitFileTree(path, i, z, (Function1<? super FileVisitorBuilder, Unit>) function1);
    }

    public static final void visitFileTree(Path path, int i, boolean z, Function1<? super FileVisitorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        PathsKt.visitFileTree(path, PathsKt.fileVisitor(function1), i, z);
    }

    public static final FileVisitor<Path> fileVisitor(Function1<? super FileVisitorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        FileVisitorBuilderImpl fileVisitorBuilderImpl = new FileVisitorBuilderImpl();
        function1.invoke(fileVisitorBuilderImpl);
        return fileVisitorBuilderImpl.build();
    }
}
