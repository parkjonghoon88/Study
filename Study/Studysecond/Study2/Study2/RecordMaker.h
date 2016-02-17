//
//  RecordMaker.h
//  Study2
//
//  Created by 박종훈 on 2016. 1. 23..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "JHRandomDataProvider.h"
#import "JHDataFileWriter.h"

@interface RecordMaker : NSObject

- (instancetype)initWithRandomStudent:(int)cnt fileName:(NSString*)fileName;

- (void)run;

- (void)readAndWrite:(JHRandomDataProvider*) dataProvider Writer:(JHDataFileWriter*) dataWriter;

@end
