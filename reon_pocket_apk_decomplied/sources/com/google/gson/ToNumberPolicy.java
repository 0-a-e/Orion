package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.math.BigDecimal;

public enum ToNumberPolicy implements ToNumberStrategy {
    DOUBLE {
        public Double readNumber(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }
    },
    LAZILY_PARSED_NUMBER {
        public Number readNumber(JsonReader jsonReader) throws IOException {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
    },
    LONG_OR_DOUBLE {
        /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|(2:12|13)(1:11)) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
            throw new com.google.gson.stream.MalformedJsonException("JSON forbids NaN and infinities: " + r3 + "; at path " + r7.getPreviousPath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0062, code lost:
            throw new com.google.gson.JsonParseException("Cannot parse " + r2 + "; at path " + r7.getPreviousPath(), r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
            r3 = java.lang.Double.valueOf(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            if (r3.isInfinite() != false) goto L_0x0021;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0011 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Number readNumber(com.google.gson.stream.JsonReader r7) throws java.io.IOException, com.google.gson.JsonParseException {
            /*
                r6 = this;
                java.lang.String r0 = "; at path "
                java.lang.String r1 = "JSON forbids NaN and infinities: "
                java.lang.String r2 = r7.nextString()
                long r3 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x0011 }
                java.lang.Long r7 = java.lang.Long.valueOf(r3)     // Catch:{ NumberFormatException -> 0x0011 }
                return r7
            L_0x0011:
                java.lang.Double r3 = java.lang.Double.valueOf(r2)     // Catch:{ NumberFormatException -> 0x0044 }
                boolean r4 = r3.isInfinite()     // Catch:{ NumberFormatException -> 0x0044 }
                if (r4 != 0) goto L_0x0021
                boolean r4 = r3.isNaN()     // Catch:{ NumberFormatException -> 0x0044 }
                if (r4 == 0) goto L_0x0027
            L_0x0021:
                boolean r4 = r7.isLenient()     // Catch:{ NumberFormatException -> 0x0044 }
                if (r4 == 0) goto L_0x0028
            L_0x0027:
                return r3
            L_0x0028:
                com.google.gson.stream.MalformedJsonException r4 = new com.google.gson.stream.MalformedJsonException     // Catch:{ NumberFormatException -> 0x0044 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0044 }
                r5.<init>(r1)     // Catch:{ NumberFormatException -> 0x0044 }
                r5.append(r3)     // Catch:{ NumberFormatException -> 0x0044 }
                r5.append(r0)     // Catch:{ NumberFormatException -> 0x0044 }
                java.lang.String r1 = r7.getPreviousPath()     // Catch:{ NumberFormatException -> 0x0044 }
                r5.append(r1)     // Catch:{ NumberFormatException -> 0x0044 }
                java.lang.String r1 = r5.toString()     // Catch:{ NumberFormatException -> 0x0044 }
                r4.<init>((java.lang.String) r1)     // Catch:{ NumberFormatException -> 0x0044 }
                throw r4     // Catch:{ NumberFormatException -> 0x0044 }
            L_0x0044:
                r1 = move-exception
                com.google.gson.JsonParseException r3 = new com.google.gson.JsonParseException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "Cannot parse "
                r4.<init>(r5)
                r4.append(r2)
                r4.append(r0)
                java.lang.String r7 = r7.getPreviousPath()
                r4.append(r7)
                java.lang.String r7 = r4.toString()
                r3.<init>(r7, r1)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.ToNumberPolicy.AnonymousClass3.readNumber(com.google.gson.stream.JsonReader):java.lang.Number");
        }
    },
    BIG_DECIMAL {
        public BigDecimal readNumber(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            try {
                return new BigDecimal(nextString);
            } catch (NumberFormatException e) {
                throw new JsonParseException("Cannot parse " + nextString + "; at path " + jsonReader.getPreviousPath(), e);
            }
        }
    }
}
