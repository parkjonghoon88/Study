//
//  RandomMain.m
//  Study2
//
//  Created by 박종훈 on 2016. 1. 30..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "RandomMain.h"
#import "JHRandomDataProvider.h"
#import "JHStudent.h"


@interface RandomMain () {
    
}
@property (nonatomic, assign) NSInteger count;
@property (nonatomic, retain) NSString *fileName;

@end

@implementation RandomMain

- (void)dealloc
{
    [super dealloc];
    [_fileName release];
}

- (instancetype)initWithCount:(NSInteger)count fileName:(NSString *)fileName
{
    self = [super init];
    if (self) {
        _count = count;
        _fileName = [fileName retain];
    }
    
    return self;
}

- (void)run
{
    JHRandomDataProvider *dataProvider = [[JHRandomDataProvider alloc] initWithCnt:self.count];
    
    NSArray *studentList = [dataProvider students];
    
    for (JHStudent *each in studentList) {
        NSLog(@"%@ %zd \n", each.studentNo, each.studentJumsu);
        
        
    }
    
    [dataProvider release];
}


@end
