.class public LHello;
.super Ljava/lang/Object;
.source "Hello.java"


# instance fields
.field public data:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static main([Ljava/lang/String;)V
    .registers 5

    .prologue
    .line 12
    new-instance v0, LHello;

    invoke-direct {v0}, LHello;-><init>()V

    .line 13
    const/4 v1, 0x2

    iput v1, v0, LHello;->data:I

    .line 14
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const/4 v2, 0x5

    const/4 v3, 0x3

    invoke-virtual {v0, v2, v3}, LHello;->foo(II)I

    move-result v0

    invoke-virtual {v1, v0}, Ljava/io/PrintStream;->println(I)V

    .line 15
    return-void
.end method


# virtual methods
.method public foo(II)I
    .registers 5

    .prologue
    .line 7
    add-int v0, p1, p2

    sub-int v1, p1, p2

    mul-int/2addr v0, v1

    return v0
.end method
