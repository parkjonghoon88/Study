//
//  main.m
//  Study2
//
//  Created by 박종훈 on 2016. 1. 23..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "RandomMain.h"
#import "RecordMaker.h"
#import "RecordAnalyzer.h"

int main(int argc, const char * argv[]) {
//    @autoreleasepool {
//        RecordMaker *main = [[RecordMaker alloc] initWithRandomStudent:3 fileName:@"testJH.txt"];
//        
//        [main run];
//        
//        [main release];
    
    RecordAnalyzer *main = [[RecordAnalyzer alloc] initWithAnalyzer:@"avg" FileName:@"testJH.txt"];
    [main run];
    [main release];
    

//    }
    
    return 0;
}
