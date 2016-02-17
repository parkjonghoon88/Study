//
//  RecordAnalyzer.h
//  Study2
//
//  Created by 박종훈 on 2016. 2. 6..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "JHRandomDataProvider.h"
#import "JHDataFileReader.h"
#import "JHCommand.h"

@interface RecordAnalyzer : NSObject

- (instancetype) initWithAnalyzer:(NSString*)commandString FileName:(NSString*)fileName;

- (void) run;

@end
