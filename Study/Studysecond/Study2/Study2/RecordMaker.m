//
//  RecordMaker.m
//  Study2
//
//  Created by 박종훈 on 2016. 1. 23..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "RecordMaker.h"

@interface RecordMaker(){
    
}

@property (nonatomic, assign)NSInteger count;
@property (nonatomic, retain)NSString* fileName;

@end

@implementation RecordMaker


-(void)dealloc{
    [super dealloc];
    [_fileName release];
}

- (instancetype)initWithRandomStudent:(int)cnt fileName:(NSString*)fileName
{
    
    self = [super init];
    
    if(self){
        _count = cnt;
        _fileName = [fileName retain];
    }
    
    
    
    return self;
}

- (void)run
{
    JHRandomDataProvider *object = [[JHRandomDataProvider alloc] initWithCnt:self.count];
    
    JHDataFileWriter *objectWriter = [[JHDataFileWriter alloc] init];
    
    [objectWriter initWithFileName:_fileName];
    
    [self readAndWrite:object Writer:objectWriter];
    
    [object release];
    [objectWriter release];
}


- (void)readAndWrite:(JHRandomDataProvider *)dataProvider Writer:(JHDataFileWriter *)dataWriter
{
    
    [dataWriter writeData:dataProvider.students];
}


@end



//public static void main(String args[])
//{
//    if(args.length < 2)
//    {
//        System.err.println("옵션을 입력해주세요");
//        System.exit(1);
//    }
//    
//    int cnt = Integer.parseInt(args[0]);
//    String fileName = args[1];
//    
//    RandomDataProvider provider = new RandomDataProvider();
//    provider.setCnt(cnt);
//    
//    DataFileWriter writer = new DataFileWriter();
//    writer.setFileName(fileName);
//    
//    readAndWrite(provider, writer);
//}
//
//private static void readAndWrite(DataProvider provider, DataWriter writer) {
//    List<Student> listData = provider.getStudents();
//    
//    writer.writeData(listData);
//}


