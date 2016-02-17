//
//  JHString.m
//  Category
//
//  Created by 박종훈 on 2016. 2. 9..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "JHString.h"

@interface JHString()
{
    
}

@property (nonatomic, strong) NSString *stringHolder;


@end

@implementation JHString



-(NSString *)jhString
{
    NSString* result = [NSString stringWithFormat:@"JH%@",self];
    return result;
}

- (instancetype)initWithCharactersNoCopy:(unichar *)characters length:(NSUInteger)length freeWhenDone:(BOOL)freeBuffer {
    self = [super init];
    if (self) {
        self.stringHolder = [[NSString alloc] initWithCharactersNoCopy:characters length:length freeWhenDone:freeBuffer];
    }
    return self;
}

- (NSUInteger)length {
    return self.stringHolder.length;
}

- (unichar)characterAtIndex:(NSUInteger)index {
    return [self.stringHolder characterAtIndex:index];
}

- (JHString *)uppercaseString
{
    return [JHString stringWithString:self.stringHolder.uppercaseString];
}

- (NSArray<JHString *> *)componentsSeparatedByString:(NSString *)separator
{
    NSArray *array = [self.stringHolder componentsSeparatedByString:separator];
    NSMutableArray *resultArray = [NSMutableArray arrayWithCapacity:array.count];
    
    for (NSString *each in array) {
        [resultArray addObject:[JHString stringWithString:each]];
    }
    
    return resultArray;
}

@end
