//
//  NSString+JHExtension.m
//  Category
//
//  Created by 박종훈 on 2016. 2. 9..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "NSString+JHExtension.h"

@implementation NSString (JHExtension)

-(NSString *)jhString
{
    NSString* result = [NSString stringWithFormat:@"JH%@",self];
    return result;
}


@end
