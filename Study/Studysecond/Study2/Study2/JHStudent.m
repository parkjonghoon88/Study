//
//  JHStudent.m
//  Study2
//
//  Created by 박종훈 on 2016. 1. 30..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "JHStudent.h"
#import "JHStudent+PrivateWrite.h"

@implementation JHStudent


- (void)dealloc
{
    [super dealloc];
    [_studentNo release];
}

#pragma mark - NSCoding
- (void)encodeWithCoder:(NSCoder *)aCoder
{
    [aCoder encodeObject:_studentNo forKey:@"Number"];
    [aCoder encodeInteger:_studentJumsu forKey:@"jumsu"];
}
- (nullable instancetype)initWithCoder:(NSCoder *)aDecoder
{
    JHStudent *student = [[JHStudent alloc] init];
    
    student->_studentNo = [aDecoder decodeObjectForKey:@"Number"];
    student.studentJumsu = [aDecoder decodeIntegerForKey:@"jumsu"];
    
    return student;
}

- (void)setStudentNo:(NSString *)studentNo
{
    [_studentNo release];
    _studentNo = [studentNo retain];
}



@end
